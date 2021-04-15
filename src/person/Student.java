
package person;

import java.util.Date;
import products.*;

public class Student {
    private String email;
    private String name;
    private Date birthDate;
    private String gender;
    private String address;
    private String residence;
    private String country;
    
    public Student(String email, String name, Date birthDate, String gender, String address, String residence, String country){
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.residence = residence;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getResidence() {
        return residence;
    }

    public String getCountry() {
        return country;
    }
    
    
}
