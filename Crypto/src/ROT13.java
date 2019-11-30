package src;

import java.security.InvalidKeyException;
import java.util.LinkedList;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Integer toChange = null;

    public ROT13(Character cs, Character cf) {
        toChange = cf - cs;

    }

    public ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException, InvalidKeyException {

        return this.encrypt(text);
    }

    public String encrypt(String text) throws InvalidKeyException {
        String result = "";
        for (int i = 0; i < text.length(); i++){
            result += convert(text.charAt(i));
        }

        return result;
    }

    public String decrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++){
            result += convert(text.charAt(i));
        }

        return result;
    }

   public char convert(char inputChar){
        char converted = inputChar;

        if (inputChar >= 'a' && inputChar <= 'm') converted += toChange;
        else if (inputChar >= 'A' && inputChar <= 'M') converted += toChange;
        else if (inputChar >= 'n' && inputChar <= 'z') converted -= toChange;
        else if (inputChar >= 'N' && inputChar <= 'Z') converted -= toChange;

        return converted;
   }

    public static String rotate(String s, Character c) {
        LinkedList addString = new LinkedList();
        int counter = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != c){
                addString.add(s.charAt(i));
                counter++;
            }
            else{
                break;
            }
        }
        String result = s.substring(counter);
        for (int j= 0; j < addString.size(); j++){
            result += addString.get(j);
        }

        return result;
    }

}
