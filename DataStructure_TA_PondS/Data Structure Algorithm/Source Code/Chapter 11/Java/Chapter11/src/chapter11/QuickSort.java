package chapter11;

public class QuickSort {
    public Comparable[] quickSort(Comparable[] theArray,int first,int last){
        int pivotIndex;
        if(first < last){
            pivotIndex = partition(theArray,first,last);
            quickSort(theArray,first,pivotIndex-1);
            quickSort(theArray,pivotIndex+1,last);
        }
        return theArray;
    }
    public int partition(Comparable[] theArray, int first,int last){
        Comparable tempItem;
        Comparable pivot = theArray[first];
        int lastS1 = first;
        for(int firstUnknown = first+1; firstUnknown <= last;firstUnknown++){
            if(theArray[firstUnknown].compareTo(pivot) < 0){
                ++lastS1;
                tempItem = theArray[firstUnknown];
                theArray[firstUnknown] = theArray[lastS1];
                theArray[lastS1] = tempItem;
            }
        }
        tempItem = theArray[first];
        theArray[first] = theArray[lastS1];
        theArray[lastS1] = tempItem;
        return lastS1;
    }   
}