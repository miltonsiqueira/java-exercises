import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class NextFibonacci {

    public static Map<Integer, Integer> mapFibonacci = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Initializing NextFibonacci");
        int[] inputs = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Type the total samples:");
            String input = br.readLine();
            int totalInputs = Integer.valueOf(input);
            inputs = new int[totalInputs];
            for(int i = 0; i < totalInputs; i++) {
                System.out.println("Type the number for the sample " + i + ":");
                inputs[i] = Integer.valueOf(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputs != null) {
            SortedSet<Integer> fibonacciValues = new TreeSet<>();

            // cache fibonacci values
            getFibonacci(60, fibonacciValues);
            System.out.println("Print next fibonacci");
            for(int i = 0; i < inputs.length; i++) {
                int num = inputs[i];
                int result = getNextFibonacci(num, fibonacciValues);
                System.out.println("Result sample " + i + ": " + result);
            }

        }
    }

    public static int getNextFibonacci(int fibonacci, SortedSet<Integer> fibonacciValues) {
        for(int value: fibonacciValues) {
            if (fibonacci < value) {
                return value;
            }
        }
        return 0;
    }

    public static int getFibonacci(int num, SortedSet<Integer> fibonacciValues) {
        Integer result = mapFibonacci.get(num);

        if(result == null) {
            if (num < 2) {
                result = num;
            } else {
                result = getFibonacci(num - 1,fibonacciValues) + getFibonacci(num - 2, fibonacciValues);
            }
            fibonacciValues.add(result);
            mapFibonacci.put(num, result);
        }

        return result;
    }
}
