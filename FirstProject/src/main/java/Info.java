import org.example.Main;

public class Info {
    static int id=101;
    static
    {
        System.out.println("Static block executed");
    }

    public static void exMethod()
    {
        System.out.println("i'm method");
    }

    public static void main(String[] args)
    {
        System.out.println(id);
        System.out.println(Info.id);
        exMethod();
    }
}
