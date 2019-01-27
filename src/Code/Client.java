package Code;

import Code.Databases.NamesDB;

import java.util.ArrayList;
import java.util.Random;

public class Client extends Thread{


    private String clientName;
    private int id;
    private String email;
    private String creditCardNumber;
    private ArrayList<WatchableElement> boughtWatchableElements;
    private Subscription subscription;

    public Client() {
        NamesDB namesDB = new NamesDB();
        ArrayList<String> clientData = namesDB.getClientData();
        this.clientName = clientData.get(0);
        this.id = Integer.valueOf(clientData.get(1));
        this.email = clientData.get(2);
        this.creditCardNumber = clientData.get(3);
        this.subscription = new Subscription();
        this.boughtWatchableElements = new ArrayList<>();
        setDaemon(true);
    }

    public void run() {
        double buyChance = 0.2, watchChance = 0.2;
        Random randomGenerator = new Random();
        while(ProgramKiller.getInstance().getRunning()) {
            while (true) {

                //If not subscribed then buy WatchableElement

                if (subscription.getPrice() == 0) {
                    double rand = Math.random();
                    if (rand <= buyChance) {
                        if (!ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().isEmpty()) {
                            int distributorsCount = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().size();
                            int distributorIndex = randomGenerator.nextInt(distributorsCount);
                            if (!ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().isEmpty()) {
                                int elementsCount = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().size();
                                int elementIndex = randomGenerator.nextInt(elementsCount);

                                WatchableElement element = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().get(elementIndex);

                                this.boughtWatchableElements.add(element);
                                Account.getInstance().accountOperations(element.getPrice());
                            }
                        }
                    }
                }

                //Watch a WatchableElement

                if (subscription.getPrice() == 0) {
                    if (!boughtWatchableElements.isEmpty()) {
                        int toWatchIndex = randomGenerator.nextInt(boughtWatchableElements.size());
                        WatchableElement element = boughtWatchableElements.get(toWatchIndex);
                        element.setViews(element.getViews() + 1);
                    }

                } else {
                    if (!ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().isEmpty()) {
                        int distributorsCount = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().size();
                        int distributorIndex = randomGenerator.nextInt(distributorsCount);
                        if (!ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().isEmpty()) {
                            int elementsCount = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().size();
                            int elementIndex = randomGenerator.nextInt(elementsCount);

                            WatchableElement element = ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList().get(distributorIndex).getProductList().get(elementIndex);
                            element.setViews(element.getViews() + 1);
                        }
                    }
                }

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void pay() {
        Account.getInstance().accountOperations(subscription.getPrice());
    }

    public String getClientName() {
        return clientName;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public ArrayList<WatchableElement> getBoughtWatchableElements() {
        return boughtWatchableElements;
    }
}
