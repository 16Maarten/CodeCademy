
package products;

import java.util.Date;

public class Module extends Content{
    private String contactPersonName;
    private String contactPersonEmail;
    private int orderNumber;
    private double version;
    
    
    public Module(double version, String contactPersonName, String contactPersonEmail, int orderNumber, int id, Date publicationDate,String status, String title, String description, String cursusName){
        super(id, publicationDate, status, title, description, cursusName);
        this.version = version;
        this.orderNumber = orderNumber;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getVersion() {
        return version;
    }
    
}
