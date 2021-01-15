import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        CalcParser calcParser = new CalcParser();
        calcParser.parse(s);

        int result = 0;

        switch (calcParser.getZ()) {
            case ('+') : result = calcParser.getA() + calcParser.getB(); break;
            case ('-') : result = calcParser.getA() - calcParser.getB(); break;
            case ('*') : result = calcParser.getA() * calcParser.getB(); break;
            case ('/') : result = calcParser.getA() / calcParser.getB(); break;
        }
        if (calcParser.isArabic()) {
            System.out.println(result);
        } else {
            System.out.println(RomeArabicUtils.getRomeNum(result));
        }
    }
}
