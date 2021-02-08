package Views;

public class OutputView {

    static public void DisplayMainMenu(){
        System.out.println();
        System.out.println("########################[ MainMenu ]######################");
        System.out.println("|| -----------------> 1 : StoreMedia  <---------------- ||");
        System.out.println("|| -----------------> 0 : Exit        <---------------- ||");
        System.out.println("##########################################################");
        System.out.print("#-> Option : ");
    }

    static public void DisplayLoginMenu(){
        System.out.println();
        System.out.println("#####################[ MainMenu ]####################");
        System.out.println("|| -----------------> 1 : Login  <---------------- ||");
        System.out.println("|| -----------------> 2 : SignUp <---------------- ||");
        System.out.println("|| -----------------> 0 : Exit   <---------------- ||");
        System.out.println("#####################################################");
        System.out.print("#-> Option : ");
    }

    public static void DisplayError(String s) { System.out.print(s); }
    public static void DisplayMessage(String s) { System.out.print(s); }
}