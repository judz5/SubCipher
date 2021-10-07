import java.util.*;
import java.math.*;

public class Runescape {

    public static String encrypt(String pt, String t){
        String plainText = pt.toLowerCase();
        int tot = Integer.parseInt(t);

        if(tot>2277){
            return "2277 is max bud quit lying";
        }
        if(tot<32){
            return "Lowest total level is 32";
        }

        int key = tot/23;
        key = key % 26;

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

        int val;
        if(text.length() % 2 != 0){
            val = (text.length()/2) + 1;
        }else{
            val = text.length()/2;
        }

        char[][] matrix = new char[val][2];

        int index = 0;

        for(int x = 0; x<=1 ; x++){
            for(int y = 0; y<val; y++){
                if(index<text.length()){
                    matrix[y][x] = text.charAt(index);
                }
                index++;
            }
        }

        StringBuilder encrypt = new StringBuilder();

        for(int y = 0; y<matrix.length ; y++){
            for(int x = 0;x<matrix[y].length; x++){
                encrypt.append(matrix[y][x]);
            }
        }

        return encrypt.toString();
    }

    public static String decrypt(String dt, String t){
        String plainText = dt.toLowerCase();
        int tot = Integer.parseInt(t);

        if(tot>2277){
            return "2277 is max bud quit lying";
        }
        if(tot<32){
            return "Lowest total level is 32";
        }

        int key = tot/23;
        key = key % 26;

        int val;
        if(plainText.length() % 2 != 0){
            val = (plainText.length()/2) + 1;
        }else{
            val = plainText.length()/2;
        }

        int index = 0;
        char[][] matrix = new char[val][2];

        for(int y = 0; y<matrix.length;y++){
            for(int x = 0; x<matrix[y].length;x++){
               if(index<plainText.length()){
                   matrix[y][x] = plainText.charAt(index);
               }
                index++;
            }
        }

        String sorted = "";

        for(int x = 0; x<2;x++){
            for(int y = 0; y<val;y++){
                sorted+=matrix[y][x];
            }
        }

        StringBuilder text = new StringBuilder();
        for(char Character : sorted.toCharArray()){
            if(Character != ' '){
                int ogPos = Character - 'a';
                int newPos = (ogPos - key)%26;
                if(newPos + 'a' < 97){
                    newPos = 122 - (96-newPos);
                }
                char newChar = (char)('a' + newPos);
                text.append(newChar);
            }else{
                text.append(Character);
            }
        }
        return text.toString();
        }



        public static String generateKey(){
        Random rand = new Random();
        int random = rand.nextInt(2277-32) + 32;
        return Integer.toString(random);
        }

    }


