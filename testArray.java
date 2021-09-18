
// Importing Arrays class from java.util package
import java.util.*;

// Main class
public class testArray {

    // Main driver method
    public static void main(String[] args) {
        // Custom input array
        // It contains 8 elements as follows
        // int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        // int[] arrNega = { 5, -100, -200, -50, -2, -1, 0, 1, 2, 3 };
        // int[] allNega = { -12, -2 };
        int[] arr = { 1, 3, 6, 4, 1, 2 };
        Arrays.sort(arr);
        System.out.println(solution(arr));
    }

    private static boolean checkAllNegative(int[] arr) {
        return Arrays.stream(arr).allMatch(x -> x <= 0);
    }

    private static boolean checkValue(int[] arr, int toCheckValue) {
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                return test;
            }
        }
        return test;
    }

    private static int[] onlyPositives(int[] arr) {
        boolean someNegative = Arrays.stream(arr).anyMatch(x -> x <= 0);
        if (someNegative) {
            int N = arr.length;
            Set<Integer> set = new HashSet<>();
            for (int a : arr) {
                if (a > 0) {
                    set.add(a);
                }
            }
            int[] primitive = set.stream().mapToInt(Integer::intValue).toArray();
            return primitive;
        }
        return arr;
    }

    public static int solution(int[] A) {
        // If all negative or 0 return 1
        // loop array and check value
        if (!checkAllNegative(A)) {
            int[] positiveArr = onlyPositives(A);
            for (int i : positiveArr) {
                if (!checkValue(positiveArr, i + 1)) {
                    return i + 1;
                }
            }
        }
        return 1;
    }
}
