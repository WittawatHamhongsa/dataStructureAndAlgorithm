int* selectionSort(int theArray[],int n){
	for(int last=n-1; last>=1; last--){
		int largest=indexofLargest(theArray,(last+1));
		int temp = theArray[largest];
		theArray[largest] = theArray[last];
		theArray[last] = temp;
	}
	return theArray;
}
int indexofLargest(int theArray[],int i){
	int indexSoFar = 0;
	for(int currIndex=1;currIndex<i;currIndex++){
		if(theArray[currIndex]>theArray[indexSoFar])
			indexSoFar = currIndex;
		}
	return indexSoFar;
}
