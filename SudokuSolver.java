public class SudokuSolver {
    private static final int SIZE = 9;
    private int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    public boolean solve() {
        int row, col;
        int[] nextEmptyCell = findEmptyCell();
        row = nextEmptyCell[0];
        col = nextEmptyCell[1];
        
        if (row == -1 && col == -1) {
            return true; 
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValidMove(row, col, num)) {
                grid[row][col] = num;

                if (solve()) {
                    return true; 
                }

                grid[row][col] = 0; // Backtrack
            }
        }

        return false; // No solution found
    }

    private boolean isValidMove(int row, int col, int num) {
        return !isInRow(row, num) && !isInColumn(col, num) && !isInBox(row - row % 3, col - col % 3, num);
    }

    private boolean isInRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int startRow, int startCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] findEmptyCell() {
        int[] result = {-1, -1};
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    result[0] = row;
                    result[1] = col;
                    return result;
                }
            }
        }
        return result;
    }

    public void printGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver(puzzle);
        if (solver.solve()) {
            System.out.println("Sudoku puzzle solved:");
            solver.printGrid();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
