package Views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int GetInt() throws InputMismatchException { return sc.nextInt();}
    public static String GetString() throws InputMismatchException{ return sc.nextLine();}
    public static void ClearInputBuffer() { sc.nextLine(); }

}
