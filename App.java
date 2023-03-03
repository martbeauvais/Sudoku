public class App {
    public static void main(String[] args) {

        Sudoku s = new Sudoku(9);

        long startMilli = System.currentTimeMillis();
        s.generate();
        long endMilli = System.currentTimeMillis();

        s.printGrid();

        System.out.println("total ms : " + (endMilli - startMilli));
        System.out.println("start    : " + startMilli);
        System.out.println("end      : " + endMilli);
        System.out.println();

    }
}