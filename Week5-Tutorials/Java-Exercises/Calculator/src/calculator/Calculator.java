/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author 041601498
 * date 01/03/2016
 * 
 * methods
 *      + void main (String[] args)
 *      + void calculator()
 */
public class Calculator 
{
    
    static Scanner inputReader = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        calculator();
    }
    
    private static void calculator()
    {
        boolean cont = true;
        double num1, num2, res = 0;
        String cmd;
        
        while (cont)
        {
            System.out.println("Enter the first number");
            num1 = inputReader.nextDouble();
            System.out.println("Enter the second number");
            num2 = inputReader.nextDouble();
            System.out.println("Choose your operator '+', '-', '/', '*', or 'exit'");
            cmd = inputReader.next();
            switch (cmd)
            {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "exit":
                    cont = false;
                    System.out.println("Exiting");
                    break;
            }     
            if (cont)
            {
                System.out.println(Double.toString(res));
            }
        }
    }
    
}
