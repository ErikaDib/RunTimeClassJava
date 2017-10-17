

public class RunTime implements RuntimeInterface{
	private long[] runTimeArr=new long[10];
	
	
	
	
	
	/*
	@Override
	public String toString(){
		String message="";
		for(int i=0;i<runTimeArr.length;i++){
			String append=String.valueOf(runTimeArr[i]);
			message=message+" "+append;
		}
		
		String avg=String.valueOf(getAverageRunTime());
		return message+"---"+avg;
		
	}
*/
	


	@Override
	public long getLastRunTime() {
		long time=0;
		for(int i=runTimeArr.length;i>=0;i--){
			if(runTimeArr[i]!=0){
				time=runTimeArr[i];
				break;
			}
		}
		
		return time;
		
	}

	@Override
	public long[] getRunTimes() {
   
		return runTimeArr ;
	}
	@Override
	public void resetRunTimes() {
		for(int i=0;i<runTimeArr.length;i++){
			runTimeArr[i]=0;
		}
		
	}

	@Override
	public void addRuntime(long runTime) {
		boolean flag=true;
		for(int i=0;i<runTimeArr.length;i++){
			flag=false;
			if(runTimeArr[i]==0){
				runTimeArr[i]=runTime;
				break;
			}
		}
		if(flag){
		for(int j=0;j<runTimeArr.length-1;j++){
			runTimeArr[j]=runTimeArr[j+1];
			
		}
		runTimeArr[9]=runTime;
		}
		
	}

	@Override
	public double getAverageRunTime() {
		double average=0;
		double counter=0;
		double divider=0;
		boolean flag=true;
		for(int i=0;i<runTimeArr.length;i++){
			if(runTimeArr[i]!=0){
				flag=false;
				counter+=runTimeArr[i];
				divider++;
				
			}
		}
		
		if(flag){
			return 0;
		}else {
			average=counter/divider;
		}
		
		return average;
	}

}
