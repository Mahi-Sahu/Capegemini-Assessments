//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MAIN{

    public static void main(String[] args) {

        Details d = new Details();
        d.setId(101);
        d.setName("Mahi");

        // Method Reference
        Printable p = d::getName;

        System.out.println("Student Name: " + p.print());

        FactorialInterface fct= new Factorial()::fact;

        System.out.println(fct.find(9));
    }
}