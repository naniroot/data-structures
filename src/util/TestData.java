package util;

import java.util.Random;

public class TestData {
    public static int[] generateRandomIntegerArray(int size) {
        int[] res = new int[size];
        Random rand = new Random();
        for(int i=0; i<size; i++) {
            res[i] = rand.nextInt();
        }
        return res;
    }

    public static int[] generateRandomIntegerArray(int size, int upperBound) {
        int[] res = new int[size];
        Random rand = new Random();
        for(int i=0; i<size; i++) {
            res[i] = rand.nextInt(upperBound);
        }
        return res;
    }

    public static void printArray(int arr[]) {
        for(int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
