package org.example;

public class VoteValid {

    public static void vote() throws AgeException
    {
        int age=18;
        if(age>=18) {
            throw new AgeException("you can vote");
        }
    }

    public static void main(String[] args)
    {
        try{
            vote();
        }
        catch(AgeException e)
        {

            System.out.println(e.getMessage());
        }

    }

}
