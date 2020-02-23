package heap;

import util.TestData;

/**
 * Everything is static for ease of coding not maintenance or production deployment :D
 */
public class HeapDataStructure {

    static int[] testArray = TestData.generateRandomIntegerArray(50, 100);

    static void printArry() {
        for(int k: testArray) {
            System.out.print(k + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        printArry();
        buildMaxHeap();
        printArry();
        heapSort();
        printArry();
    }

    public static void maxHeapify(int heapSize, int index) {
        int left = 2 * index;
        int right = (2 * index) + 1;
        int largest = index;
        if(left < heapSize && testArray[left-1] > testArray[largest-1]) {
            largest = left;
        }
        if(right < heapSize && testArray[right-1] > testArray[largest-1]) {
            largest = right;
        }
        if(index != largest) {
            int temp = testArray[largest-1];
            testArray[largest-1] = testArray[index-1];
            testArray[index-1] = temp;
            maxHeapify(heapSize, largest);
        }
    }

    public static void buildMaxHeap() {
        int k = testArray.length/2;
        for(int i=k; i>0; i--) {
            maxHeapify(testArray.length, i);
        }
    }

    public static void heapSort() {
        for(int i=testArray.length; i>1; i--) {
            int temp = testArray[0];
            testArray[0] = testArray[i-1];
            testArray[i-1] = temp;
            maxHeapify(i, 1);
        }
    }
}
