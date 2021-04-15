
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

    public String getSubject() {
        return subject;
    }

    public String getIntroText() {
        return introText;
    }

    public int getDifficultyIndicator() {
        return difficultyIndicator;
    }

    public ArrayList<Module> getModuleList() {
        return moduleList;
    }

    public ArrayList<Webcast> getWebcastList() {
        return webcastList;
    }
    
    public String getCursusName(){
        return this.cursusName;
    }
}
