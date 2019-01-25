package Code.GUI;

import Code.ClientsAndDistributorsListsSingleton;
import Code.Distributor;

public class Controller {
    public void addDistributor() {
        Distributor newDistributor = new Distributor();
        ClientsAndDistributorsListsSingleton.getInstance().addDistributor(newDistributor);
        System.out.println("Distributor Added!");
    }

}
