import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fr13dman on 1/13/17.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParanthesisAlgo {

    private static final Map<Character, Character> symbolMap;
    static {
        symbolMap = new HashMap<Character, Character>();
        symbolMap.put('}', '{');
        symbolMap.put(']', '[');
        symbolMap.put(')', '(');
    }

    public static void main(String args []) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(input + " -> " + (new ValidParanthesisAlgo().isValid(input)));
    }

    public boolean isValid(String s) {
        if(s == null || s.isEmpty())
            return false;

        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();

        for(char c : charArray) {
            if(symbolMap.containsKey(c) && stack.isEmpty())
                return false;

            //should be the right parenthesis character
            if(symbolMap.containsKey(c)) {
                if(stack.pop() != symbolMap.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return  stack.isEmpty();
    }
}
