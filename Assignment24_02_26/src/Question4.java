interface Irefer{
    A createStu(String n,int m);
}

class A{
    private String name;
    private int marks;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class Factory{
    public A createObj(String n,int m) {
        A a = new A();
        a.setName(n);
        a.setMarks(m);
        return a;
    }
}

public class Question4 {
    public static void main(String[] args) {
        Irefer r = new Factory()::createObj;
        A a = r.createStu("Balraj",95);
        System.out.println("Name: "+a.getName());
        System.out.println("Marks: "+a.getMarks());
    }
}