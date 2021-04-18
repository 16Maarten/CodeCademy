package TestsSrc;
public class Url {
    public static boolean validateURL(String url) {
        
        
        if (!url.contains("https:")) {
            return false;
        }
        
        String parts[] = url.split("https:");
        String parts1[] = url.split("\\//");
        String part = parts1[0];
        String part1 = parts1[1];
        
        
        
        
        if (part1.startsWith("\\.") || part1.endsWith("\\.") || part1.length() < 1) {
            return false;
        }
        String parts2[] = part1.split("\\.");
        String part3 = parts2[1];
        
        if(part3.length() <= 1){
            return false;
        }
        
        String part4 = parts2[2];
        
        if (part4.length() > 1) {
            return true;
        }
        return false;
    }
}
