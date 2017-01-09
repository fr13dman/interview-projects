import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fr13dman on 1/8/17.
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 */

class Node {
    private Integer index = null;
    private List<Integer> adjacencyList = null;

    public Node(int index) {
        this.index = index;
        this.adjacencyList = new ArrayList<Integer>();
    }

    public void addEdge(int index) {
        this.getAdjacencyList().add(index);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Integer> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Integer> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}


public class BFSShortestReachAlgo {

    public BFSShortestReachAlgo() {

    }

    private List<Node> generateNodes(int

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while(q-- > 0) {
            int nodes = in.nextInt();
            int edges = in.nextInt();


        }
    }

}
