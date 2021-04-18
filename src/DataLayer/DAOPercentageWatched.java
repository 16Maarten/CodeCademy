/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.util.List;
import person.PercentageWatched;

public interface DAOPercentageWatched {
    public List<PercentageWatched> findPercentageWatched();
    public boolean addPercentageWatched(PercentageWatched percentageWatched);
    public boolean updatePercentageWatched(PercentageWatched percentageWatched);
}
