package chapter11;

public class BinarySearch {

    public boolean BinarySearch(Comparable[] theArray, Comparable key, int n) {
        int first = 0;
        int last = n;
        int mid = Math.round((first + last) / 2);
        while (first < last) {
            if (key.compareTo(theArray[mid]) == 0) {
                return true;
            } else if (key.compareTo(theArray[mid]) < 0) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
            mid = Math.round((first + last) / 2);
        }
        return false;
    }
}
