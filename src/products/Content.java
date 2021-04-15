
package products;

import java.util.Date;

public abstract class Content {
    private int id;
    private Date publicationDate;
    private String status;
    private String title;
    private String description;
    private String cursusName;
    
    public Content(int id, Date publicationDate,String status, String title, String description, String cursusName){
        this.id = id;
        this.publicationDate = publicationDate;
        this.status = status;
        this.title = title;
        this.description = description;
        this.cursusName = cursusName;
    }

    public int getId() {
        return id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCursusName() {
        return cursusName;
    }
    
}
