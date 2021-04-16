package Application_Logic;

import DataLayer.DAOFactory;
import java.util.List;
import products.Webcast;

public class WebcastManager {

    private List<Webcast> webcasts;

    public WebcastManager(DAOFactory daoFactory) {
        this.webcasts = daoFactory.createDAOWebcast().findWebcast();
    }

    public List<Webcast> getWebcasts() {
        return webcasts;
    }

}
