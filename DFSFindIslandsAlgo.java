import java.util.Scanner;

/**
 * Created by fr13dman on 1/10/17.
 * http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class DFSFindIslandsAlgo {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        //printGrid(n, m, grid);

        int[][] visited = new int[n][m];

        int islandCount = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m;  j++) {

                //if we find island search for island
                if(visited[i][j] != 1 && grid[i][j] == 1) {
                    flagGridforContiguousIsland(grid, visited, i, j);
                    islandCount++;
                }
            }

        System.out.println("Found " + islandCount + " islands.");
    }

    private static void flagGridforContiguousIsland(int[][] grid, int[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(visited[i][j] == 1 || grid[i][j] == 0)
            return;

        if(grid[i][j] == 1)
            visited[i][j] = 1; // set visited to 1

        flagGridforContiguousIsland(grid, visited, i + 1, j);
        flagGridforContiguousIsland(grid, visited, i, j + 1);
        flagGridforContiguousIsland(grid, visited, i - 1, j);
        flagGridforContiguousIsland(grid, visited, i, j - 1);
        flagGridforContiguousIsland(grid, visited, i + 1, j + 1);
        flagGridforContiguousIsland(grid, visited, i - 1, j - 1);
    }

    private static void printGrid(int n, int m, int[][] a) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.printf("%5d", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
