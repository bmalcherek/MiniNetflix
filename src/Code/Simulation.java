package Code;

import java.util.Random;

import static java.lang.Thread.sleep;


public class Simulation{

    Thread simulation;
    boolean running;

    public void startSimulation() {
        double newClientsPct = 0.015;
        TimeHandler timeHandler = new TimeHandler();
        timeHandler.setDaemon(true);
        timeHandler.start();
        running = true;
        Runnable task = () -> {
            while (true) {

                //New clients
                Random randomGenerator = new Random();
                int clientCount = ClientsAndDistributorsListsSingleton.getInstance().getClientsList().size();
                int newClients = (int)(randomGenerator.nextInt(clientCount + 1) * newClientsPct);
                for (int i = 0; i < newClients; i++) {
                    Client newClient = new Client();
                    ClientsAndDistributorsListsSingleton.getInstance().addClient(newClient);
                }

                //End of the month payments
                if (timeHandler.checkIfEndOfMonth()) {
                    System.out.println("Payment time");
                    for (Client client : ClientsAndDistributorsListsSingleton.getInstance().getClientsList()) {
                        client.pay();
                    }
                    System.out.println("Account balance: " + Account.getInstance().getBalance());
                    for (Distributor distributor : ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList()) {
                        distributor.checkout();
                    }
                    System.out.println("Account balance: " + Account.getInstance().getBalance());
                }


                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        simulation = new Thread(task);
        simulation.start();
//        new Thread(task).start();
    }

    public void endSimulation() {
        running = false;
    }

}



