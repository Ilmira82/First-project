public class CalcParser {

    private int a = 0;
    private int b = 0;
    private char z = '?';
    private boolean isArabic;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public char getZ() {
        return z;
    }

    public boolean isArabic() {
        return isArabic;
    }

    private void checkNum(int n) throws Exception {
        if (n < 1 || n > 10) { //
            throw new Exception("Необходимо ввести числа от 1 до 10");
        }
    }

    public void parse(String s) throws Exception {

        String str = s;

        str = str.replace(" ", "");
        str = str.toUpperCase();


        if (str.indexOf('+') > 0) {
            this.z = '+';
        } else if (str.indexOf('-') > 0) {
            this.z = '-';
        } else if (str.indexOf('*') > 0) {
            this.z = '*';
        } else if (str.indexOf('/') > 0) {
            this.z = '/';
        } else {
            throw new Exception("Введено неверное выражение");
        }

        String str2;

        str2 = str.substring(0, str.indexOf(this.z));
        try {
            this.a = Integer.parseInt(str2);
            this.isArabic = true;
        } catch (Exception e) {
            this.a = RomeArabicUtils.getArabicNum(str2);
            this.isArabic = false;
        }
        checkNum(this.a);

        str2 = str.substring(str.indexOf(this.z) + 1);
        try {
            if (this.isArabic) {
                this.b = Integer.parseInt(str2);
            } else {
                this.b = RomeArabicUtils.getArabicNum(str2);
            }
        } catch (Exception e) {
            throw new Exception("Все числа должны быть либо арабскими, либо римскими");
        }
        checkNum(this.b);
    }
}
