/**
 * Created by shaheenz on 12/22/16.
 *
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 */

import java.util.*;

public class DFSRegionAlgo {

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

        System.out.println(new DFSRegionAlgo().dfsMaxRegion(n, m, grid));
    }

    private int dfsMaxRegion(int n, int m, int[][] grid) {
        //step 1 - clone grid to track visited cells and count using dfs
        int[][] visited = new int[n][m];

        //printGrid(n, m, grid);
        //printGrid(n, m, visited);

        // traverse grid and count cells
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                max = Math.max(max, countAdjacentCells(grid, visited, i, j));
            }
        return max;
    }

    private int countAdjacentCells(int[][] grid, int[][] visited, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return 0;

        if(grid[x][y] == 0 || visited[x][y] == 1) return 0;
        visited[x][y] = 1;

        int count = 1;
        count += countAdjacentCells(grid, visited, x + 1, y);
        count += countAdjacentCells(grid, visited, x - 1, y);
        count += countAdjacentCells(grid, visited, x, y + 1);
        count += countAdjacentCells(grid, visited, x, y - 1);
        count += countAdjacentCells(grid, visited, x + 1, y + 1);
        count += countAdjacentCells(grid, visited, x - 1, y - 1);
        count += countAdjacentCells(grid, visited, x + 1, y - 1);
        count += countAdjacentCells(grid, visited, x - 1, y + 1);

        return count;
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
