public class App {
    public static void main(String[] args) {

        Sudoku s = new Sudoku(9);

        long startTime = System.nanoTime();
        s.generate();
        long endTime = System.nanoTime();

        long nanoTimer = endTime - startTime;

        s.printGrid();

        System.out.println("total nano sec  : " + nanoTimer);
        System.out.println("total milli sec : " + nanoTimer / 1000000);

        System.out.println();
    }
}