package InvoicingSystem;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StartUpTest extends TestCase{
	public void testStartUp()
	{
		String args[]={"Test"};
		presentation.StartUp.main(args);
		assertTrue( true );
	}
}
