package org.example;

public class Testcode {
    public static String greet(String name) {
        name=name.toUpperCase();
        StringBuilder greeting = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            int secretCode = getSecretCode(currentChar);
            if(secretCode>9)
            {
                greeting.append(secretCode).append("");
            }
            else{
                greeting.append("0").append(secretCode).append("");
            }

        }
        return greeting.toString().trim();
    }
    private static int getSecretCode(char c) {
        int code= c - 'A' + 1;
//        System.out.println(code);
        return code;
    }

    public static void main(String[] args) {
        String name = "jaYA";
        String greeting = greet(name);
        System.out.println(greeting);
    }
}
