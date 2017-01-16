import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        printPermutations(nums);
    }

    private static void printPermutations(int[] nums) {
        if(nums.length == 1) return;

        List<String> list = getPermutations(nums);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> getPermutations(int[] nums) {
        List<String> arrayList = new ArrayList<String>();

        if(nums.length == 1) {
            arrayList.add(nums[0] + "");
            return arrayList;
        }

        int num = nums[0];
        arrayList = getPermutations(Arrays.copyOfRange(nums, 1, nums.length));

        List<String> permutations = new ArrayList<String>();
        for (String s : arrayList) {
            for (int j = 0; j <= s.length(); j++)
                permutations.add(insertNum(s, num, j));
        }
        return permutations;
    }

    private static String insertNum(String s, int num, int i) {
        return s.substring(0, i) + num + s.substring(i);
    }
}
