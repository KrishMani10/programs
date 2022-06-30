package mani.utils;

public class Encryption {
    public static String encryptingPassword(String password){

        StringBuilder encryptedVal = new StringBuilder();

        for(char ch : password.toCharArray()){
            if(ch == 'Z'){
                encryptedVal.append('A');
            }
            else if(ch == 'z'){
                encryptedVal.append('a');
            }
            else
            {
                encryptedVal.append((char) (ch + 1));
            }
        }
        return encryptedVal.toString();
    }
}
