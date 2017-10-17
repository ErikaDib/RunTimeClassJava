

public class SelectionSort extends RunTime implements SortInterface {

	

	@Override
	public void sort(Integer[] arrayToSort) {
		long startTime=System.nanoTime();
		for(int i=0;i<arrayToSort.length-1;i++){
			int index=i;
			for(int j=i+1;j<arrayToSort.length;j++){
				if(arrayToSort[j]<arrayToSort[index]){
					index=j;
				}
			}
			int min=arrayToSort[index];
			arrayToSort[index]=arrayToSort[i];
			arrayToSort[i]=min;
		}
		long endTime=System.nanoTime();
		long runTime_number =endTime-startTime;
		addRuntime(runTime_number);
	}

}
