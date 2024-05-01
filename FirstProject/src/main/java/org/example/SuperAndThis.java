package org.example;

class SuperAndThis
{
    String name="Muzamil";
    public void add()
    {
        System.out.println("Super keyword");
    }
}

class SuperAndThis1 extends SuperAndThis{
    int number=10;
    public void sub()
    {
        System.out.println(super.name);
        System.out.println(this.number);
    }

    public static void main(String[] args)
    {
        SuperAndThis1 obj=new SuperAndThis1();
        obj.sub();
    }

}
