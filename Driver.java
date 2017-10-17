

import java.util.Random;

public class Driver implements DriverInterface {
	
	

	public static void main(String[] args) {
		//SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes
		//BubbleSort, SelectionSort, InsertionSort
		//Equal, Random, Increasing, Decreasing, IncreasingAndRandom
		int numberOfTime=10;
		int arraySize1=1000;
		int arraySize2=10000;
		Driver d1=new Driver();
	    for(SortType sort:SortType.values()) {
	    	   for(ArrayType type:ArrayType.values()) {
	    		//	RunTime h = new RunTime();
	    		   System.out.println("\n"+sort+","+" "+type+","+" "+arraySize1+"\n");
	    		  long[] printRunTime= d1.runSort(sort, type, arraySize1, numberOfTime).getRunTimes();
	    		  double avg=d1.runSort(sort, type, arraySize1, numberOfTime).getAverageRunTime();
	    		   for(int i=0;i<printRunTime.length;i++) {
	    			  System.out.print(printRunTime[i]+" ");
	    		   }
	    		   
	    		   System.out.print("--"+avg);
	    	   }
	    }
	    for(SortType sort:SortType.values()) {
	    	   for(ArrayType type:ArrayType.values()) {
	    		   System.out.println("\n"+sort+","+" "+type+","+" "+arraySize2+"\n");
	    		   long[] printRunTime= d1.runSort(sort, type, arraySize2, numberOfTime).getRunTimes();
	    		   d1.runSort(sort, type, arraySize1, numberOfTime);
	    		   double avg=d1.runSort(sort, type, arraySize2, numberOfTime).getAverageRunTime();
	    		   for(int i=0;i<printRunTime.length;i++) {
		    			  System.out.print(printRunTime[i]+" ");
		    		   }
		    		   
		    		   System.out.print("--"+avg);
	    	   }
	    }
	    
	
	}
	
	@Override
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		
		Integer[] arr=new Integer[arraySize];
		    	switch(arrayType) {
		    	case Equal:
		    	 	//Integer[] arr1=new Integer[arraySize];
		    		Random random=new Random();
		    		int randomNum=random.nextInt(arraySize)+1;
		    		 for(int i=0;i<arr.length;i++) {
		    			 arr[i]=new Integer(randomNum);
		    		 }
		    	     
		    		return arr;
		    	case Random:
		    		 Random random1=new Random();
		    		 for(int i=0;i<arr.length;i++) {
		    			 int randomNum1=random1.nextInt(arraySize)+1;
		    			 arr[i]=new Integer(randomNum1);
		    		 }
		    		   return arr;
		    	case Increasing:
		    		for(int i=0;i<arr.length;i++) {
		    			arr[i]=new Integer(i);
		    		}
		    		return arr;
		    	case Decreasing:
		    		int temp=arr.length-1;
		    		 for(int i=0;i<arr.length;i++) {
		    			arr[i]=new Integer(temp);
		    			temp--;
		    	}
		    		return arr;
		    	case IncreasingAndRandom:
		    		int percentage=(int) (arraySize*0.9);
		    		for(int i=0;i<percentage;i++) {
		    			arr[i]=new Integer(i);
		    		}
		    		for(int i=percentage;i<arr.length;i++) {
		    			Random random2=new Random();
			    		int randomNum2=random2.nextInt(((arr.length-1)-percentage)+1)+(percentage);
		    			arr[i]=new Integer(randomNum2);
		    		}
		    		return arr;
				default:
					break;
		    		
		    	}
		   
				return arr;
		    }
			


	@Override
	public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
		//BubbleSort, SelectionSort, InsertionSort
		
		
	 	switch(sortType) {
	 	case BubbleSort:
	 		//RunTime runtime1=new RunTime();
	 		BubbleSort bsort=new BubbleSort();
			for(int i=0;i<numberOfTimes;i++) {
				Integer[] arrayCreated=createArray(arrayType,arraySize);
				bsort.sort(arrayCreated);
	 	}

			return bsort;
		case InsertionSort:
			SelectionSort ssort=new SelectionSort();
			//RunTime runTime=new RunTime();
			for(int i=0;i<numberOfTimes;i++) {
				Integer[] arrayCreated=createArray(arrayType,arraySize);
				ssort.sort(arrayCreated);
	 	}
			
			return ssort;
		case SelectionSort:
			InsertionSort isort=new InsertionSort();
			//RunTime runTime=new RunTime();
			for(int i=0;i<numberOfTimes;i++) {
				Integer[] arrayCreated=createArray(arrayType,arraySize);
				isort.sort(arrayCreated);
	 	}
	
			return isort;
		default:
			break; 
			
			
		}
		return null;
	}

}
