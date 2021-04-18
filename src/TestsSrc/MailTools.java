package TestsSrc;
import java.util.regex.Pattern;

public class MailTools {
    private String email;
    public MailTools(String email) {
        this.email = email;
    }
    
    public boolean validateMailAddress(){
        if(this.email.indexOf("@") == -1){
            return false;
        }
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (this.email == null)
            return false;
        return pat.matcher(this.email).matches();
    }
}
