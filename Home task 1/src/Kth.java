import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long numStep = 9;
        byte symbolsNum = 1;
        long minNum = 0;
        long num;
        byte resChar = 0;
        while (k >= 0) {
            k -= symbolsNum * numStep;
            symbolsNum++;
            numStep *= 10;
        }
        symbolsNum--;
        numStep /= 10;
        if (k < 0) {
            k += symbolsNum * numStep;
        }
        for (int i = 1, s = 1; i < symbolsNum; i++) {
            minNum += 9L * s;
            s *= 10;
        }
        num = minNum + 1 + k / symbolsNum;
        for (int i = 0; i < symbolsNum - k % symbolsNum; i++) {
            resChar = (byte) (num % 10);
            num /= 10;
        }
        System.out.println(resChar);
    }
}