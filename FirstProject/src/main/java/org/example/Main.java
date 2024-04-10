package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        System.out.println(Main.id);
        exMethod();
    }
}