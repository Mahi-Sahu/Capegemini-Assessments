interface lambda{
    public int calc(int a, int b);
}
public class Question1 {
    public static void main(String[] args) {
        lambda l=(x,y)->{
            return (int) Math.pow(x, y);
        };

        System.out.println(l.calc(2, 3));

    }

}
