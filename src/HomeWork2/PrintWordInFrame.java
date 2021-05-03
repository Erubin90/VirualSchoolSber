package HomeWork2;
import java.util.Scanner;
//
public class PrintWordInFrame {
    public static void main(String[] args) {
        System.out.println("Hello. I type the word in a frame");
        printWordInFrame();
    }
    public static void printWordInFrame () {
        var in = new Scanner(System.in);
        System.out.println("Please write height, length and word:");
        System.out.print("height - ");
        int height = in.nextInt();
        System.out.print("length - ");
        int length = in.nextInt();
        System.out.print("word - ");
        String word = in.next();
        System.out.println("One second\n");

        int height1 = (height - 2 - 1) / 2;
        int height2 = height - 2 - 1 - height1;

        if (word.length() < length && height > 3) {
            System.out.println("Voila!!!");
            printPoint(length);
            printBetween(length - 2, height1);
            printWord(length, word);
            printBetween(length - 2, height2);
            printPoint(length);
        } else {
            System.out.println("Error!!!");
            if (word.length() < length && height < 3) {
                System.out.println("The word length is longer than the frame length");
                System.out.println("The specified height is less than the minimum required");
            } else if (height > 3) {
                System.out.println("The specified height is less than the minimum required");
            } else if (word.length() < length) {
                System.out.println("The word length is longer than the frame length");
            }
        }
    }

    public static void printPoint (int x) {
        for (int i = 1; i <= x; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public static void printBetween (int x, int y) {
        for (int i = 1; i <= y; i++) {
            System.out.print("*");
            WhiteSpace(x);
            System.out.print("*");
            System.out.println();
        }
    }
    public static void printWord (int x, String word) {
        int j1 = (x - 2 - word.length()) / 2;
        int j2 = x - 2 - word.length() - j1;
        System.out.print("*");
        WhiteSpace(j1);
        System.out.print(word);
        WhiteSpace(j2);
        System.out.print("*");
        System.out.println();
    }
    public static void WhiteSpace (int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
    }
}
