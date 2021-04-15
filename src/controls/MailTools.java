
package controls;


public class MailTools {

   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static boolean validateMailAddress(String mailAddress){
        if(!mailAddress.contains("@")){
            return false;
        }
        String parts[] = mailAddress.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        
        String parts2[] = part2.split("\\.");
        String part3 = parts2[0];
        String part4 = parts2[1];
        
        
        if(part1.length() <= 1){
            return false;
        }else if(mailAddress.split("@")[1].split("\\.").length > 2){
            return false;
        }else if(part3.length() <= 1
                || part4.length() <= 1
                ){
       return false;
    }
        return true;
    }
        
    
}
