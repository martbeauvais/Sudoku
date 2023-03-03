
import java.util.Random;

public class Sudoku {
    private Random rand = new Random();
    private int x;
    private int gridSize;
    private int[][] grid;
    private int ligne;
    private int colonne;
    private int count = 0;
    private int boxSize;
    private int countTotal = 0;

    /*
     * constructeur
     */
    public Sudoku(int gridSize) {
        this.gridSize = gridSize;
        grid = new int[gridSize][gridSize];
        if (gridSize != 4 && gridSize != 9 && gridSize != 16 && gridSize != 25 && gridSize != 36 && gridSize != 49
                && gridSize != 64 && gridSize != 81 && gridSize != 100) {
            // The gridSize is anything other than 4, 9, 16, 25, 36, 49, 64, 81 or 100
            System.out.println();
            System.out.println(" choisir 4, 9, 16, 25, 36, 49, 64, 81 ou 100 ");
            System.out.println();
            System.exit(0);
        }

    }

    /* méthode pour générer un tableau */
    public void generate() {
        for (ligne = 0; ligne < gridSize; ligne++) {
            for (colonne = 0; colonne < gridSize; colonne++) {
                x = rand.nextInt(gridSize) + 1;
                if (scan()) {

                    for (int i = 0; i < gridSize - 1; i++) {
                        if (!scan()) {
                            grid[ligne][colonne] = x;
                            break;
                        } else if (x == gridSize) {
                            x = 1;
                        } else {
                            x++;
                        }
                    }

                    if (grid[ligne][colonne] == 0) {
                        ligne = 0;
                        colonne = -1;
                        count++;

                        if (count > (gridSize * gridSize)) {
                            clearGrid();
                            count = 0;
                            countTotal++;
                        }
                    }
                } else {
                    grid[ligne][colonne] = x;
                }
            }
        }
    }

    /* méthode pour détecter x dans une ligne, une colonne ou une box */
    private boolean scan() {

        // scan line
        for (int i = 0; i < gridSize; i++) {
            if (grid[ligne][i] == x) {
                return true;
            }
        }
        // scan column
        for (int i = 0; i < gridSize; i++) {
            if (grid[i][colonne] == x) {
                return true;
            }
        }
        // scan box
        boxSize = (int) Math.sqrt(gridSize);
        int boxLine = ligne - ligne % boxSize;
        int boxColumn = colonne - colonne % boxSize;

        for (int i = boxLine; i < boxLine + (gridSize / boxSize); i++) {
            for (int j = boxColumn; j < boxColumn + (gridSize / boxSize); j++) {
                if (grid[i][j] == x)
                    return true;
            }
        }
        return false;
    }

    /* method pour effacer le tableau et recommencer */
    private void clearGrid() {

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = 0;
            }
        }
        ligne = 0;
        colonne = -1;

    }

    /* méthode pour afficher le tableau */
    public void printGrid() {
        System.out.println();
        for (int i = 0; i < gridSize; i++) {
            if (i % boxSize == 0 && i != 0) {
                String separateur = "";
                for (int j = 0; j < gridSize; j++) {
                    System.out.print(separateur);
                }
                System.out.println();
            }
            for (int j = 0; j < gridSize; j++) {
                if (j % boxSize == 0 && j != 0) {
                    System.out.print("     ");
                }
                if (grid[i][j] <= 9) {
                    System.out.print("    " + grid[i][j]);
                } else if (grid[i][j] > 9 && grid[i][j] < 100) {
                    System.out.print("   " + grid[i][j]);
                } else {
                    System.out.print("" + grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("calls to clearGrid : " + countTotal);
    }
}
