import java.util.Locale;

public class Substitution {

    public static String encrypt(String pt, String k){
        String encrypted = "";
        String plainText = pt.toUpperCase();
        String key = k.toUpperCase();

       if(key.length() != 26){
            return "Key must be 26 Characters! Yours is : " + key.length();
        }

        String[] keyAlphabet = new String[key.length()];

        for(int i = 0; i<key.length(); i++){
            keyAlphabet[i] = String.valueOf(key.charAt(i));
        }

        for(int i = 0; i < plainText.length(); i++){
            int index = plainText.charAt(i) - 65; // Subtract 65 cause ascii value offset

            if(index > plainText.length() || index < 0){ // if its a special case then just leave it (were only changing alphabetic characters)
                encrypted += String.valueOf((plainText.charAt(i)));
            }else{
                encrypted += keyAlphabet[index];
            }
        }

        return encrypted;
    }

    public static String decrypt(String ct, String k){
        String decrypted = "";
        String cipherText = ct.toUpperCase();
        String key = k.toUpperCase();

        if(key.length() != 26){
            return "Key must be 26 Characters! Yours is : " + key.length();
        }

        for(int i = 0; i < cipherText.length(); i++) {

            char character = cipherText.charAt(i);
            int index = key.indexOf(character);
            int val = index + 65; // + 65 to get ascii value (all upper case duh)

            if (val < 65 || val > 90) { // boom special cases again
                decrypted += String.valueOf(character); // just give the char cause its special case
            } else {
                decrypted += String.valueOf((char)val); // give the ascii value
            }
        }
        return decrypted;
    }

}