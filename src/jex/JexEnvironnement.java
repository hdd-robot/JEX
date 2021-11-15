package jex;

public abstract class JexEnvironnement {
	
	
	
	public static void init() {
		
	}
	

	public static  int getRefreshTime() {
		return JexEnvironnement.refreshTime;
	}


	public  static void setRefreshTime(int refreshTime) {
		JexEnvironnement.refreshTime = refreshTime;
	}
	
	protected static volatile int refreshTime = 1000;
	

}
