package chapter11;

public class SequentialSearch {

    public boolean SequentialSearch(Comparable[] theArray, Comparable key, int n) {
        for (int count = 0; count < n; count++) {
            if (theArray[count].compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }
}
