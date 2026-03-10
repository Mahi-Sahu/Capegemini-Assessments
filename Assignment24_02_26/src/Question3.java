interface val{
    public boolean valid(String n,String p);
}
public class Question3 {
    public static void main(String[] args) {
        String name ="bal";
        String pass = "666";
        val v=(x,y)->{
            if(x.equals(name)&&y.equals(pass))
                return true;
            return false;
        };
        System.out.println(v.valid("bal", "666"));
    }
}