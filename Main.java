import java.util.Random;
import java.util.ArrayList;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        // variables
        Scanner sc = new Scanner(System.in);
        String str; // string to be randomized
        int run; // number of times the string will be randomized
        boolean keepInitial; // keep the first character of the string
        Random rnd = new Random();
        ArrayList<Integer> chosen = new ArrayList<>();
        StringBuilder out;
        StringBuilder clipping = new StringBuilder();
        int random;

        // welcome message and instructions
        System.out.println("--- Welcome to String Randomizer! ---");
        System.out.println("This program will randomize a string and copy it to the clipboard.\n");

        // inputs
        System.out.println("Enter the string of which you want to randomize: ");
        str = sc.next();
        System.out.println("Enter the number of times you want to randomize the string: ");
        run = sc.nextInt();
        System.out.println("Do you want to keep the first character of the string? (y/n)");
        String choice = sc.next();
        keepInitial = choice.equals("y"); // y = true, n = false

        // randomize the string
        for(int j = 0; j < run; j++) {
            chosen.clear();
            out = new StringBuilder(str.length());
            if (keepInitial) {
                chosen.add(0);
                out.append(str.charAt(0));
            }

            for (int i = 0; i < str.length() - 1; i++) {
                random = rnd.nextInt(str.length());
                if (!chosen.contains(random)) {
                    chosen.add(random);
                    out.append(str.charAt(random));
                } else {
                    i--;
                }
            }
            clipping.append(out).append("\n");
            System.out.println(out);
        }
        // copy to clipboard
        StringSelection stringSelection = new StringSelection(clipping.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // complete message
        System.out.println("\nDone!");
        System.out.println("All of the randomized strings have been copied to clipboard.\n");
    }
}