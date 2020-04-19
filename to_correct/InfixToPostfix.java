/* filter InfixToPostfix that converts an arithmetic
expression from infix to postfix if fully parenthesized */
import java.util.Scanner;
public class InfixToPostfix
{
    public static void main(String[] args)  // e.g. (((A+B)*C)-((D-E)*(F+G))) -> A B + C * D E - F G - * +
    {
      Queue<Character> variables = new Queue<Character>();
      Queue<Character> operations = new Queue<Character>();

      Scanner reader = new Scanner(System.in);

      String s = reader.next();
      s = s.replaceAll("\\s+","");

      String actions = "+-/*";

      for (int i = 0; i < s.length(); i++)
      {
          Character toQueue = s.charAt(i);
          if (actions.indexOf(toQueue) >= 0) operations.enqueue(toQueue);
          else if (!toQueue.equals('(')) variables.enqueue(toQueue);
      }


      while (!variables.isEmpty()) {
          Character var = variables.dequeue();
          if (!var.equals(')')) System.out.print(var + " ");
          else System.out.print(operations.dequeue() + " ");
      }
      System.out.println();
    }
}
