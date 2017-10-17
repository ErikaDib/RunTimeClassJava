

public class InsertionSort extends RunTime implements SortInterface {
	
	
	
	
	

	@Override
	public void sort(Integer[] arrayToSort) {
		long startTime=System.nanoTime();
		int length=arrayToSort.length;
		for(int j=1;j<length;j++){
			int key=arrayToSort[j];
			int number=j-1;
			while((number>-1)&&(arrayToSort[number]>key)){
				arrayToSort[number+1]=arrayToSort[number];
				number--;
			}
			arrayToSort[number+1]=key;
		}
		long endTime=System.nanoTime();
		long runTime_number =endTime-startTime;
		addRuntime(runTime_number);	
		
	}

}
