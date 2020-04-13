public class Filter // reads strings from standard input, prints them sorted with duplicates removed
{
    public static void main(String[] args) {
        String[] lines = StdIn.readAllLines();
        Merge.sort(lines);
        String currentElement = "";
        for (int i = 0; i < lines.length; i++)
        {
          if (!lines[i].equals(currentElement))
          {
            StdOut.println(lines[i]);
            currentElement = lines[i];
          }
        }
    }
}
