int* insertionSort(int theArray[],int n){
	for(int unsorted=1;unsorted<n;unsorted++){
		int newItem = theArray[unsorted];
		int loc = unsorted;
		while((loc>0)&&(theArray[loc-1]>newItem)){
			theArray[loc] = theArray[loc-1];
			loc--;
		}
		theArray[loc] = newItem;
	}
	return theArray;
}
