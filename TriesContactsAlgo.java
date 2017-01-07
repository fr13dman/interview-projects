import java.util.*;

/**
 * Created by fr13dman on 1/5/17.
 *
 * https://www.hackerrank.com/challenges/ctci-contacts
 *
 * Test Input (Adding contacts):
 * 2
 * add hack
 * add hackerrank
 *
 *
 */

class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private String completeWord;
    private Integer val = 0;

    public TrieNode addChild(String s) {
        if(s == null || s.isEmpty())
            return null;

        char[] chars = s.toCharArray();

        TrieNode result = null;
        for(char c : chars)
            if(result == null)
                result = addChild(c, this);
            else
                result = addChild(c, result);

        result.setCompleteWord(s);
        return result;
    }

    private TrieNode addChild(Character c, TrieNode node) {
        if(node == null)
            throw new IllegalArgumentException("Null node passed to addChild call!");

        TrieNode result = null;

        if(node.getChildren().containsKey(c)) {
            result = node.getChildren().get(c);
        } else {
            result = new TrieNode();
            node.getChildren().put(c, result);
        }
        result.val++;
        return result;
    }

    public int searchPartial(String partial) {
        if(partial == null || partial.isEmpty())
            return 0;

        return searchPartial(partial, this);
    }

    private int searchPartial(String partial, TrieNode node) {
        if(node == null) {
            System.out.println("Partial " + partial + " string not found!");
            return 0;
        }

        char[] chars = partial.toCharArray();
        TrieNode nextNode = node;
        for(char c : chars) {
            if(nextNode.getChildren().containsKey(c)) {
                nextNode = nextNode.getChildren().get(c);
            } else {
                nextNode = null;
                break;
            }
        }

        return nextNode == null ? 0 : nextNode.val;
    }


    public List<String> enumerateCompletedWords() {
        return this.enumerateCompletedWords(this);
    }

    private List<String> enumerateCompletedWords(TrieNode node) {
        if(node == null)
            return new ArrayList<String>();

        List<String> result = new ArrayList<String>();

        if(node.getCompleteWord() != null)
            result.add(node.getCompleteWord());

        for(TrieNode _node : node.getChildren().values()) {
            result.addAll(enumerateCompletedWords(_node));
        }

        return result;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public String getCompleteWord() {
        return completeWord;
    }

    public void setCompleteWord(String completeWord) {
        this.completeWord = completeWord;
    }
}


public class TriesContactsAlgo {

    private TrieNode root = null;

    TriesContactsAlgo() {
        root = new TrieNode();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        TriesContactsAlgo driver = new TriesContactsAlgo();

        //start time
        long startTime = System.nanoTime();

        for(int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            switch (op) {
                case "add":
                    driver.addName(contact);
                    break;
                case "find":
                    System.out.println(driver.searchPartial(contact));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid op command entered. Only 'add' and 'find' operations are supported!");
            }
        }

        //end time
        long endTime = System.nanoTime();
        System.out.println("That took " + (endTime - startTime)/1000000 + " milliseconds");

        System.out.println("All Contacts: " + Arrays.toString(driver.root.enumerateCompletedWords().toArray()));
    }

    public boolean addName(String name) {
        TrieNode node = this.root.addChild(name);
        return node != null;
    }

    public int searchPartial(String partial) {
        return this.root.searchPartial(partial);
    }
}
