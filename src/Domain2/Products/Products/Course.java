
package Domain.Products.products;

import java.util.ArrayList;


public class Course {
    private String courseName;
    private String subject;
    private String introText;
    private int difficultyIndicator;
    private ArrayList<Module> moduleList;
    private ArrayList<Webcast> webcastList;
    
    public Course(String courseName, String subject, String introText, int difficultyIndicator){
        this.courseName = courseName;
        this.subject = subject;
        this.introText = introText;
        this.difficultyIndicator = difficultyIndicator;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
}
