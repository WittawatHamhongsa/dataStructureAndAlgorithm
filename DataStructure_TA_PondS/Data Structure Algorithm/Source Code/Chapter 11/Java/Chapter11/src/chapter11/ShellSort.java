package chapter11;

public class ShellSort {

    public Comparable[] shellSort(Comparable[] theArray, int n) {
        int h = Math.round(n / 2);
        while (h > 0) {
            shell(theArray, h, n);
            h = Math.round(h / 2);
        }
        return theArray;
    }

    public void shell(Comparable[] theArray, int h, int n) {
        int index = 0;
        while ((index + h) <= n) {
            index += h;
        }
        while (index > 0) {
            int indexData1 = 0;
            int indexData2 = indexData1 + h;
            while (indexData2 < index) {
                if (theArray[indexData1].compareTo(theArray[indexData2]) > 0) {
                    Comparable temp = theArray[indexData1];
                    theArray[indexData1] = theArray[indexData2];
                    theArray[indexData2] = temp;
                }
                indexData1 = indexData2;
                indexData2 += h;
            }
            index -= h;
        }
    }
}
