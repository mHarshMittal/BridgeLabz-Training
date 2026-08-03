import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
      Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    List<Integer> ans = new ArrayList<>();

    for (String op : operations) {

        String[] arr = op.split(" ");
        int type = Integer.parseInt(arr[0]);

        // Push the element 
        if (type == 1) {

            int value = Integer.parseInt(arr[1]);
            stack.push(value);

            if (maxStack.isEmpty() || value >= maxStack.peek()) {
                maxStack.push(value);
            }

        }
        // Pop value 
        else if (type == 2) {

            int remove = stack.pop();

            if (remove == maxStack.peek()) {
                maxStack.pop();
            }

        }
        // Print Max
        else {

            ans.add(maxStack.peek());

        }
    }

    return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
