package Application_Logic;

import DataLayer.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import person.PercentageWatched;
import products.Course;
import products.Webcast;
import products.Module;

public class PercentageWatchedManager {

    private List<PercentageWatched> percentageWatched;
    private DAOFactory daoFactory;

    public PercentageWatchedManager(DAOFactory daoFactory) {
        this.percentageWatched = daoFactory.createDAOPercentageWatched().findPercentageWatched();
        this.daoFactory = daoFactory;
    }

    public boolean updatePercentageWatched(int percentage, String email, int contentItemId) {
        return this.daoFactory.updatePercentageWatched(new PercentageWatched(percentage, email, contentItemId));
    }

    public boolean addPercentageWatched(int percentage, String email, int contentItemId) {
        percentageWatched.add(new PercentageWatched(percentage, email, contentItemId));
        return this.daoFactory.addPercentageWatched(new PercentageWatched(percentage, email, contentItemId));
    }

    public List<PercentageWatched> getPercentageWatched() {
        return percentageWatched;
    }

}
