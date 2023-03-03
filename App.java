public class App {
    public static void main(String[] args) {

        Sudoku s = new Sudoku(9);

        long startMilli = System.currentTimeMillis();
        s.generate();
        long endMilli = System.currentTimeMillis();
        s.printGrid();
        System.out.println("temps d'execution en milli secondes: " + (endMilli - startMilli));
        System.out.println();

    }
}