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
    private String completeWord = null;

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

        return result;
    }

    public List<String> searchPartial(String partial) {
        if(partial == null || partial.isEmpty())
            return new ArrayList<String>();

        return searchPartial(partial, this);
    }

    private List<String> searchPartial(String partial, TrieNode node) {
        if(node == null) {
            System.out.println("Partial " + partial + " string not found!");
            return new ArrayList<String>();
        }

        char[] chars = partial.toCharArray();
        List<String> result = new ArrayList<String>();

        TrieNode nextNode = node;
        for(char c : chars) {
            if(nextNode.getChildren().containsKey(c)) {
                nextNode = nextNode.getChildren().get(c);
            } else {
                nextNode = null;
                break;
            }
        }

        return enumerateCompletedWords(nextNode);
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

        //System.out.println("All Contacts: " + Arrays.toString(driver.root.enumerateCompletedWords().toArray()));
    }

    public boolean addName(String name) {
        TrieNode node = this.root.addChild(name);
        return node != null;
    }

    public int searchPartial(String partial) {
        List<String> stringList = this.root.searchPartial(partial);
        //System.out.println(Arrays.toString(stringList.toArray()));
        return stringList.size();
    }

    public int searchCompleteWord(String word) {
        return 0;
    }

    private List<String> searchPartial(String partial, TrieNode root) {
        return null;
    }


}
