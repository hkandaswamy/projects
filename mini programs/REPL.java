import java.util.*;
import java.io.*;
import java.math.*;

/**
 * This program calculates a given postfix expression
 * typed by the user. It uses BigInteger in order to be
 * able to calculate much larger numbers.
 *
 * @author Harish Kandaswamy (3265)
 * @version 19 May 2019
 */
public class REPL {
        public static void main(String[]args) {
                Scanner kb = new Scanner(System.in);
                BigInteger result;
                String input = "";
                System.out.println("Welcome to the postfix calculator!");
                System.out.println("Enter your postfix expression here: ");
                while(kb.hasNextLine()) {
                        input = kb.nextLine();
                        try {
                                result = calculate(input);
                                System.out.println("Answer: " + result);
                                System.out.println("Enter another expression: ");
                        }
                        catch (ArithmeticException | IllegalArgumentException | NoSuchElementException e) {
                                System.out.println("Error! Try again: ");
                        }
                }
                System.out.print("Goodbye!");
        }
        
        private static BigInteger calculate(String input) {
                Scanner expression = new Scanner(input);
                Deque20<BigInteger> deque = new Deque20<>();
                while(expression.hasNext()) {
                        String token = expression.next();
                        if(!(token.equals("+")) && !(token.equals("-")) && !(token.equals("*"))
                           && !(token.equals("/")) && !(token.equals("%"))) {
                                deque.push(new BigInteger(token));
                        }
                        else if(token.equals("+")) {
                                BigInteger x = deque.pop();
                                BigInteger y = deque.pop();
                                BigInteger z = y.add(x);
                                deque.push(z);
                        }
                        else if(token.equals("-")) {
                                BigInteger x = deque.pop();
                                BigInteger y = deque.pop();
                                BigInteger z = y.subtract(x);
                                deque.push(z);
                        }
                        else if(token.equals("*")) {
                                BigInteger x = deque.pop();
                                BigInteger y = deque.pop();
                                BigInteger z = y.multiply(x);
                                deque.push(z);
                        }
                        else if(token.equals("/")) {
                                BigInteger x = deque.pop();
                                BigInteger y = deque.pop();
                                BigInteger z = y.divide(x);
                                deque.push(z);
                        }
                        else if(token.equals("%")) {
                                BigInteger x = deque.pop();
                                BigInteger y = deque.pop();
                                BigInteger z = y.remainder(x);
                                deque.push(z);
                        }
                        else {
                                throw new IllegalArgumentException();
                        }        
                }
                if(deque.size() > 1) {
                        throw new IllegalArgumentException();
                }
                else {
                        return deque.pop();
                }
        }
}