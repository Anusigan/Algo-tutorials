package findMultiples;

// This java program is designed to find duplicates and triplicates
// in an array of integers and to measure the time taken to find them


//A dynamic array implementation
import java.util.ArrayList;

//Provides the utility methods like  "shuffle' for manipulating colletions
import java.util.Collections;

/**
 * @author klaus
 */


public class FindMultiples {

    /*
     *Find an index where a value in the array occurs for the second time
     * Returns -1 if no such index exists
     */


    //Purpose of this method to find  the first duplicate value in the list
    public static int findDuplicate(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++)  //Iterates through each element in the list
            for (int j = 0; j < i; j++)
                if (numbers.get(i) == numbers.get(j))  //Compares the current element with all previous elements
                    return i; // Return i if an duplicate is found
        return -1;  // Failure case
    }

    /*
     * Find an index where a value in the array occurs for the third time
     * Returns -1 if no such index exists
     */



    public static int findTriplicate(ArrayList<Integer> numbers) {
        // TO DO
        return -1;  // Failure case
    }

    public static ArrayList<Integer> createInput(int size, int repeats, boolean shuffle) {
        ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = repeats; i < size; i++)
            result.add(i);
        for (int i = 0; i < repeats; i++)
            result.add(0);
        if (shuffle)
            Collections.shuffle(result);
        return result;
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 100000;
        // Whether the input should be shuffled
        boolean shuffle = true;
        // Whether to look for triplicate values
        boolean triplicates = false;
        // Whether to print data. Only use with small numbers of values.
        boolean printData = false;

        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = createInput(numValues, (triplicates ? 3 : 2), shuffle);
        // Optionally print the data (to check correctness)
        if (printData) {
            System.out.print("Input values: ");
            for (int i = 0; i < data.size(); i++)
                System.out.print(data.get(i) + " ");
            System.out.println();
        }

        // Run one of the find functions; 
        // Check time before and after to measure runtime 
        long start = System.currentTimeMillis();
        // Pick the function based on whether we are looking for triplicates
        int result = triplicates ? findTriplicate(data) : findDuplicate(data);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if (result >= 0)
            System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
        else
            System.out.println("Result: nothing found");
        System.out.println("Elapsed time = " + elapsed + " seconds");

    }

}

