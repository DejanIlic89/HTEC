package data;

/**
 *
 * @author Dejan
 */

public class FillData {
    
    public static String getRandomText() {
        return "Test".concat(String.valueOf((int)(Math.random()*10000)));
    }
    
    public static int getRandomNumber(int number) {
        return ((int)(Math.random() * number));
    }
    
}
