
package Domain.Products.products;

public class Module{

    private String contactPersonName;
    private String contactPersonEmail;
    private int orderNumber;
    private double version;
    
    
    public Module(double version, int orderNumber, String contactPersonName, String contactPersonEmail){
        this.version = version;
        this.orderNumber = orderNumber;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
    }
}
