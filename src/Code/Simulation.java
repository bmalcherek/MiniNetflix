package Code;

import java.util.Random;

import static java.lang.Thread.sleep;


public class Simulation{

    Thread simulation;
    TimeHandler timeHandler;

    public void startSimulation() {
        double newClientsPct = 0.015;
        timeHandler = new TimeHandler();
        timeHandler.setDaemon(true);
        timeHandler.start();
//        Runnable task = () -> {
//            while(ProgramKiller.getInstance().getRunning()) {
//                while (true) {
//
//                    //New clients
//                    Random randomGenerator = new Random();
//                    int clientCount = ClientsAndDistributorsListsSingleton.getInstance().getClientsList().size();
//                    int newClients = (int) (randomGenerator.nextInt(clientCount + 1) * newClientsPct);
//                    for (int i = 0; i < newClients; i++) {
//                        Client newClient = new Client();
//                        ClientsAndDistributorsListsSingleton.getInstance().addClient(newClient);
//                    }
//
//                    //End of the month payments
//                    if (timeHandler.checkIfEndOfMonth()) {
//                        System.out.println("Payment time");
//                        for (Client client : ClientsAndDistributorsListsSingleton.getInstance().getClientsList()) {
//                            client.pay();
//                        }
//                        System.out.println("Account balance: " + Account.getInstance().getBalance());
//                        for (Distributor distributor : ClientsAndDistributorsListsSingleton.getInstance().getDistributorsList()) {
//                            distributor.checkout();
//                        }
//                        System.out.println("Account balance: " + Account.getInstance().getBalance());
//                    }
//
//
//                    try {
//                        sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        };

        Thread t = new Thread(() ->  {
            while(ProgramKiller.getInstance().getRunning()) {
                while (true) {

                    //New clients
                    Random randomGenerator = new Random();
                    int clientCount = ClientsAndDistributorsListsSingleton.getInstance().getClientsList().size();
                    int newClients = (int) (randomGenerator.nextInt(clientCount + 1) * newClientsPct);
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
                        sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}



