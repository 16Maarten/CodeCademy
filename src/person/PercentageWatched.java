
package person;

import java.util.ArrayList;
import java.util.List;


public class PercentageWatched {
    private int percentage;
    private String Email;
    private int contentItemId;

    public PercentageWatched(int percentage, String Email, int contentItemId) {
        this.percentage = percentage;
        this.Email = Email;
        this.contentItemId = contentItemId;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getEmail() {
        return Email;
    }

    public int getContentItemId() {
        return contentItemId;
    }
    
    
    
}
