import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RomeArabicUtils {

    public static String getRomeNum(int arabicNum) throws Exception {
        if (arabicNum <= 0) {
            throw new Exception("Число должно быть больше нуля");
        }
        String result = "";
        int n = arabicNum;

        for (RomeNum romeNum : RomeNum.values()) {
            while (n >= romeNum.getNum()) {
                result += romeNum.name();
                n -= romeNum.getNum();
            }
        }
        return result;
    }

    private static void checkRomeNum(String romeNum) throws Exception {
        String s = "[^MCDLXVI]";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(romeNum);
        if (matcher.find()) {
            throw new Exception("Передано не римское число");
        }
    }

    public static int getArabicNum (String romeNum) throws Exception {
        if (romeNum.length() == 0) {
           throw new Exception("Передана пустая строка");
        }

        String s = romeNum.toUpperCase();
        checkRomeNum(s);

        int result = 0;
        for (RomeNum num : RomeNum.values()) {
            while (s.indexOf(num.name()) == 0) {
                result += num.getNum();
                s = s.substring(num.name().length());
            }
        }
        return result;
    }
}
