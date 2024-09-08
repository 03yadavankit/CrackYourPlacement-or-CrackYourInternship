package Day39of45;

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int noOfEmptySquares = 0;
        int startingSquareRow = 0;
        int startingSquareColumn = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0)
                    noOfEmptySquares++;
                else if (grid[r][c] == 1) {
                    startingSquareRow = r;
                    startingSquareColumn = c;
                }
            }
        }
        return path(grid, startingSquareRow, startingSquareColumn, noOfEmptySquares);
    }

    private int path(int[][] grid, int startingSquareRow, int startingSquareColumn, int noOfEmptySquares) {
        if (startingSquareRow < 0 || startingSquareColumn < 0 || startingSquareRow >= grid.length
                || startingSquareColumn >= grid[0].length || grid[startingSquareRow][startingSquareColumn] == -1) {
            return 0;
        }
        if (grid[startingSquareRow][startingSquareColumn] == 2) {
            return noOfEmptySquares == -1 ? 1 : 0;
        }
        grid[startingSquareRow][startingSquareColumn] = -1;
        noOfEmptySquares--;
        int totalCount = path(grid, startingSquareRow + 1, startingSquareColumn, noOfEmptySquares)
                + path(grid, startingSquareRow, startingSquareColumn + 1, noOfEmptySquares)
                + path(grid, startingSquareRow - 1, startingSquareColumn, noOfEmptySquares)
                + path(grid, startingSquareRow, startingSquareColumn - 1, noOfEmptySquares);
        grid[startingSquareRow][startingSquareColumn] = 0;

        return totalCount;
    }
}
