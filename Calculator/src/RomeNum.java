public enum RomeNum {
    M(1000), CM(900), D(500), CD(400), C(100), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private int num;

    RomeNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
