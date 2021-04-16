package Application_Logic;

import DataLayer.DAOFactory;
import java.util.List;
import products.Module;

public class ModuleManager {

    private List<Module> modules;

    public ModuleManager(DAOFactory daoFactory) {
        this.modules = daoFactory.createDAOModule().findModule();
    }

}
