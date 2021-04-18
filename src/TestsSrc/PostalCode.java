package TestsSrc;
public class PostalCode {
    private String postalCode;

     
    public String FormatPostalCode(String PostalCode){
        if(postalCode == null){
            throw new NullPointerException("PostalCode Cannot Be null");
        }else if(Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 
                && Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999  
                && postalCode.trim().substring(4).trim().length() == 2
                &&  postalCode.trim().substring(4).trim().toUpperCase().charAt(0) >= 'A' 
                && postalCode.trim().substring(4).trim().toUpperCase().charAt(1) >= 'A'
                &&  postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' 
                && postalCode.trim().substring(4).trim().toUpperCase().charAt(1) <= 'Z'){
            
            postalCode.trim();
            String answer = postalCode.trim().substring(0, 4) + " " + postalCode.trim().substring(4).trim().toUpperCase();
            return answer;
            
        }
        else{
            throw new IllegalArgumentException("Invalid PostalCode");
        }  
    }
}
