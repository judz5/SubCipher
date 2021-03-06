import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.math.*;

public class Substitution {

    public static String encrypt(String pt, String k){
        String encrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = k.toUpperCase();
        String plainText = pt.toUpperCase();


       if(key.length() != 26){
            return "Key must be 26 Characters! Yours is : " + key.length();
        }

        String[] keyAlphabet = new String[key.length()];

        for(int i = 0; i<key.length(); i++){
            keyAlphabet[i] = String.valueOf(key.charAt(i));
        }

        for(int i = 0; i < plainText.length(); i++){
            int index = plainText.charAt(i) - 65; // Subtract 65 cause ascii value offset

            if(index > key.length() || index < 0){ // if its a special case then just leave it (were only changing alphabetic characters)
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
                String hold = String.valueOf(character);
                decrypted += hold; // just give the char cause its special case
            } else {
                String holding = String.valueOf((char)val);
                decrypted += holding; // give the ascii value
            }
        }
        return decrypted;
    }

    public static String generateKey(){
    String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        String s = output.toString();
        return s;
    }

}