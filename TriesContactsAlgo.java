import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shaheenz on 1/5/17.
 *
 * https://www.hackerrank.com/challenges/ctci-contacts
 */

class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private String completeWord = null;

    public boolean addChild(Character c) {
        if(getChildren().containsKey(c)) {
            //something
        } else {
            TrieNode node = new TrieNode();
            getChildren().put(c, node);
        }

        return false;
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

    }

    public boolean addName(String name) {
        return false;
    }

    public int searchPartial(String partial) {
        return 0;
    }

    private List<String> searchPartial(String partial, TrieNode root) {
        return null;
    }


}
