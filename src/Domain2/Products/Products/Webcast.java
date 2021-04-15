package Domain.Products.products;

import java.sql.Date;

public class Webcast{
    private Date dateOfPublication;
    private String duration;
    private String url;
    private String expertName;
    private String expertOrganisation;
    
    
    public Webcast(String duration, String url, String expertName, String expertOrganisation){
        
        this.duration = duration;
        this.url = url;
        this.expertName = expertName;
        this.expertOrganisation = expertOrganisation;
    }
    

            
}
