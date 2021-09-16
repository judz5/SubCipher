public class Substitution {


    String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    public static String encrypt(String plainText, String key){
        String encrypted = "";

        if(key.length() != 26){
            return "Alphabet Key must be 26 Characters!";
        }

        String[] keyAlphabet = new String[key.length()];
        for(int i = 0; i<key.length(); i++){
            keyAlphabet[i] = 
        }

        return encrypted;
    }

}
