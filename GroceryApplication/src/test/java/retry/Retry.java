package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLlimit = 2;
	public boolean retry(ITestResult result) {
		if( counter < retryLlimit)
		{
			counter++;
			return true;
		}
		return false;
	}


}