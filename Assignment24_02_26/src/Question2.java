interface sp{
    public String intput(String s);
}
public class Question2 {
    public static void main(String[] args) {
        sp s=(x)->{
            StringBuilder sb =new StringBuilder();
            for(char a:x.toCharArray()) {
                sb.append(a);
                sb.append(" ");
            }
            return sb.toString();
        };
        System.out.println(s.intput("balraj"));
    }
}