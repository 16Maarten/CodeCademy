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

    public boolean deletePercentageWatched(String email, int contentItemId) {
        for (int i = 0; i < this.percentageWatched.size(); i++) {
            if (this.percentageWatched.get(i).getEmail().equals(email)&& this.percentageWatched.get(i).getContentItemId() == contentItemId ) {
                boolean answer = this.daoFactory.removePercentageWatched(this.percentageWatched.get(i));
                this.percentageWatched.remove(this.percentageWatched.get(i));
                return answer;
            }
        }
        return false;
    }

    public List<PercentageWatched> getPercentageWatched() {
        return percentageWatched;
    }

}
