import java.util.Scanner;

/**
 * Created by fr13dman on 1/13/17.
 * https://leetcode.com/problems/permutations/
 *
 *  Given a collection of distinct numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
    ]
 *
 *
 */

public class GeneratePermutationsAlgo {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        int i = 0;
        while (in.hasNext()) {
            nums[i++] = in.nextInt();
        }

        printPermutations(nums);
    }

    private static void printPermutations(int[] nums) {
        int length = nums.length;

        for(int i = 0; i < length; i++) {

        }
    }
}
