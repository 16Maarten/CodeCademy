
package products;

import java.util.Date;

public class Webcast extends Content{
    private String duration;
    private String url;
    private String expertName;
    private String expertOrganisation;
    
    
    public Webcast(String duration, String url, String expertName, String expertOrganisation, int id, Date publicationDate,String status, String title, String description, String cursusName){
        super(id, publicationDate, status, title, description, cursusName);
        this.duration = duration;
        this.url = url;
        this.expertName = expertName;
        this.expertOrganisation = expertOrganisation;
    }


    public String getDuration() {
        return duration;
    }

    public String getUrl() {
        return url;
    }

    public String getExpertName() {
        return expertName;
    }

    public String getExpertOrganisation() {
        return expertOrganisation;
    }
    

            
}
