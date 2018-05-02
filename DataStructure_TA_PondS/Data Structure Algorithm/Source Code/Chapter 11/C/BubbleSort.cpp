int* bubbleSort(int theArray[],int n){
	for(int pass=1;pass<n;pass++){
		for(int index=0;index<n-pass;index++){
			int nextIndex = index+1;
			if(theArray[index]> theArray[nextIndex]){
				int temp = theArray[index];
				theArray[index] = theArray[nextIndex];
				theArray[nextIndex] = temp;
			}
		}
	}
	return theArray;
}
