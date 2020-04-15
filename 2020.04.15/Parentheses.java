/* stack client Parentheses that reads a string e.g. [()]{}{[()()]()}
and returns true if it's correct and false if not (e.g. for [(]) ) */
import java.util.Scanner;
public class Parentheses
{
    public static void main(String[] args)  // and returns true if it's correct and false if not (e.g. for [(]) )
    {
      Stack<Character> stack = new Stack<Character>();
      Scanner reader = new Scanner(System.in);

      String s = reader.next();

      Character lastChar = 'a';

      for (int i = 0; i < s.length(); i++)
      {
          Character toPush = s.charAt(i);

          if ((lastChar.equals('{') && toPush.equals('}')) ||
                  (lastChar.equals('(') && toPush.equals(')')) ||
                  (lastChar.equals('[') && toPush.equals(']'))) {
              stack.pop();
              if (!stack.isEmpty()) {
                  lastChar = stack.pop();
                  stack.push(lastChar);
              }
              else lastChar = 'a';
          }
          else {
              stack.push(toPush);
              lastChar = toPush;
          }
      }
      System.out.println(stack.isEmpty());
    }
}
