interface Ifact{
    public int fact(int a);
}

class Fact{
    public int facto(int a) {
        if(a == 0)
            return 0;
        if(a == 1)
            return 1;
        //System.out.println(a);
        return a*facto(a-1);
    }
}
public class Question5 {
    public static void main(String[] args) {
        Ifact f = new Fact()::facto;
        System.out.println(f.fact(5));
    }
}