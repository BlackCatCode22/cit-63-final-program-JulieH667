import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchComplexity {

    // This is the Linear search method where the array.length and iterations begin. 
    public static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i;  // Returns index of found element, and the system.out.println is for the output.
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1;  // The target is not found here and this is how I set up.
    }

    // The Binary Search Method is the target and array.
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1, 0);
    }

    // Recursive Binary Search Method. This is where the target is at and used the recursive.
    public static int binarySearch(int[] array, int target, int left, int right, int iterations) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;
            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;
            }
            if (array[mid] < target) {
                return binarySearch(array, target, mid + 1, right, iterations);
            } else {
                return binarySearch(array, target, left, mid - 1, iterations);
            }
        }
        System.out.println("Binary search iterations: " + iterations);
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter number of elements in array:");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Array size should be greater than 0.");
                return;
            }
            int[] array = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Enter target number to search:");
            int target = scanner.nextInt();

            // Linear Search, to find the target, this is what I chose to input. 
            int linearResult = linearSearch(array, target);
            System.out.println((linearResult == -1) ? "Target not found by linear search." :
                    "Target found by linear search at index: " + linearResult);

            // Binary Search// this is what I input to see If I could get a result and I used additional help. 
            Arrays.sort(array);
            int binaryResult = binarySearch(array, target);
            System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                    "Target found by binary search at index: " + binaryResult);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }                    // my ending to this code, it was very tricky and I had to search for additional help but it was a lot of fun!!
}

