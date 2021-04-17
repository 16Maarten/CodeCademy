public class MailTools {
    public static boolean validateMailAddress(String mailAddress){
        if(mailAddress.indexOf("@") == -1){
            return false;
        }
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (mailAddress == null)
            return false;
        return pat.matcher(mailAddress).matches();
    }
}
