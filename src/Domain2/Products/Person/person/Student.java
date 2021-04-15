
package Domain.Products.Person.person;

import java.util.Date;
import Domain.Products.Person.*;

public class Student {
    private String email;
    private String name;
    private Date birthDate;
    private char gender;
    private String address;
    private String residence;
    private String country;
    
    public Student(String email, String name, Date birthDate, char gender, String address, String residence, String country){
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.residence = residence;
        this.country = country;
    }
    
    
    
    
}
