import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.math.*;

public class Runescape {

    public static String encrypt(String pt, int tot){
        String plainText = pt.toLowerCase();
        int key = tot/23;

        StringBuilder text = new StringBuilder();
        for(char Character : plainText.toCharArray()){
            if(Character != ' '){
                int ogPos = Character - 'a';
                int newPos = (ogPos + key) % 26;
                char newChar = (char)('a' + newPos);
                text.append(newChar);
            }else{
                text.append(Character);
            }
        }
        return text.toString();
    }

}
