
package products;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String cursusName;
    private String subject;
    private String introText;
    private int difficultyIndicator;
    private List<Module> moduleList;
    private List<Webcast> webcastList;
    
    public Course(String cursusName, String subject, String introText, int difficultyIndicator){
        this.cursusName = cursusName;
        this.subject = subject;
        this.introText = introText;
        this.difficultyIndicator = difficultyIndicator;
        this.moduleList = new ArrayList();
        this.webcastList = new ArrayList();
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

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public void setWebcastList(List<Webcast> webcastList) {
        this.webcastList = webcastList;
    }
    

    public List<Webcast> getWebcastList() {
        return webcastList;
    }
    
    public String getCursusName(){
        return this.cursusName;
    }
}
