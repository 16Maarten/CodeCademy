
package products;

import java.util.ArrayList;

public class Course {
    private String cursusName;
    private String subject;
    private String introText;
    private int difficultyIndicator;
    private ArrayList<Module> moduleList;
    private ArrayList<Webcast> webcastList;
    
    public Course(String cursusName, String subject, String introText, int difficultyIndicator){
        this.cursusName = cursusName;
        this.subject = subject;
        this.introText = introText;
        this.difficultyIndicator = difficultyIndicator;
    }
    
    public String getCursusName(){
        return this.cursusName;
    }
}
