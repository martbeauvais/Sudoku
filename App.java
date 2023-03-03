public class App {
    public static void main(String[] args) {

        Sudoku s = new Sudoku(9);

        long startTime = System.nanoTime();
        s.generate();
        long endTime = System.nanoTime();

        long nanotime = endTime - startTime;

        s.printGrid();

        System.out.println("total nano sec  : " + nanotime);
        System.out.println("total milli sec : " + nanotime / 1000000);

        System.out.println();

    }
}