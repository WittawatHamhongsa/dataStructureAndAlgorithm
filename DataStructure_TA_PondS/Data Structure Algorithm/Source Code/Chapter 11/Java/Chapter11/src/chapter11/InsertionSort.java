package chapter11;

public class InsertionSort {
    public Comparable[] insertionSort(Comparable[] theArray,int n){
        for(int unsorted=1;unsorted<n; unsorted++){
            Comparable nextItem = theArray[unsorted];
            int loc = unsorted;
            while((loc>0)&&(theArray[loc-1].compareTo(nextItem)>0)){
                theArray[loc] = theArray[loc-1];
                loc--;
            }
            theArray[loc] = nextItem;
        }
        return theArray;
    }    
}
