

public class BubbleSort extends RunTime implements SortInterface {

	

	@Override
	public void sort(Integer[] arrayToSort) {
	long startTime=System.nanoTime();
    int length=arrayToSort.length;
   // int temp=0;
      for(int i=0;i<length-1;i++){
    	  for(int j=0;j<(length-i-1);j++){
    		  if(arrayToSort[j]>arrayToSort[j+1]){
    			 int temp=arrayToSort[j];
    			  arrayToSort[j]=arrayToSort[j+1];
    			  arrayToSort[j+1]=temp;
    			  
    		  }
    	  }
      }
	long endTime=System.nanoTime();
	long runTime_number =endTime-startTime;
	addRuntime(runTime_number);
	}

}
 