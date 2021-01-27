package utilities;

import java.util.concurrent.TimeUnit;

public class utilities {

	public static void pause(int milliseconds) {
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	}
}
