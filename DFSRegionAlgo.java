/**
 * Created by shaheenz on 12/22/16.
 *
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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

        dfsMaxRegion(n, m, grid);
    }

    private static int dfsMaxRegion(int n, int m, int[][] grid) {
        //step 1 - clone grid to track visited cells
        int[][] visited = new int[n][m];
        System.arraycopy(grid, 0, visited, 0, grid.length);

        printGrid(n, m, grid);
        printGrid(n, m, visited);

        //step 2 - create max_region variable and traverse grid for regions

        return 0;
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
