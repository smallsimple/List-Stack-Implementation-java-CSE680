import junit.framework.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleVMTest extends TestCase {

	public void testConstructor() {

		StringReader strReader;
        BufferedReader buffReader;
        
		// Test on bad input parameter (boundary case)
        boolean flag = false;
        try 
        {
        	new SimpleVM(null);
        } 
        catch (IOException e) 
        {
            flag = true;
        }
        assertTrue(flag);
        
        // Test on empty program
        flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("");
            buffReader = new BufferedReader(strReader);
            new SimpleVM(buffReader);
            flag = true;
        } 
        catch (IOException e) 
        {
            // do nothing
        } 
        assertTrue(flag);
        
        // Test on a simple (correct) program
        flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("push 5\npop answer");
            buffReader = new BufferedReader(strReader);
            new SimpleVM(buffReader);
            flag = true;
        } 
        catch (IOException e) 
        {
            // do nothing
        }
        assertTrue(flag);
        
        // Test on a simple (correct) program
        flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("pUsH 5\npop answer");
            buffReader = new BufferedReader(strReader);
            new SimpleVM(buffReader);
            flag = true;
        } 
        catch (IOException e) 
        {
            // do nothing
        }
        assertTrue(flag);
        
        // Test on a simple (syntactically incorrect) program
        flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("posh 5\npop answer");
            buffReader = new BufferedReader(strReader);
            new SimpleVM(buffReader);
        } 
        catch (IOException e) 
        {
        	flag = true;
        }
        assertTrue(flag);
        
        // continue testing ...
	}
	
	public void testRun()
	{
		StringReader strReader;
        BufferedReader buffReader;
        SimpleVM vm;
        
		// Test on empty program
        boolean flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("");
            buffReader = new BufferedReader(strReader);
            vm = new SimpleVM(buffReader);
            
            // execute the program
            vm.run();
            flag = true;
        } 
        catch (IOException e) 
        {
            // do nothing
        } 
        assertTrue(flag);
        
        // Test on a simple (correct) program
        flag = false;
        try 
        {
        	// load the simple vm program
            strReader = new StringReader("push 5\npop answer");
            buffReader = new BufferedReader(strReader);
            vm = new SimpleVM(buffReader);

            // execute the program
            vm.run();
            flag = true;
        } 
        catch (IOException e) 
        {
            // do nothing
        }
        assertTrue(flag);
        
        // Test on a program with a run-time error
        flag = false;
        try 
        {
            strReader = new StringReader("pop sum");
            buffReader = new BufferedReader(strReader);
            vm = new SimpleVM(buffReader);

            vm.run();
        } 
        catch (IOException e) 
        {
            // do nothing
        } 
        catch (RuntimeException r) 
        {
            flag = true;
        }
        assertTrue(flag);

        // continue testing ...
    }
	
	public void testGetValue()
	{
		StringReader strReader;
        BufferedReader buffReader;
        SimpleVM vm = null;
        
		// Test on empty program
	    boolean flag = false;
	    try 
	    {
	    	// load the simple vm program
	        strReader = new StringReader("");
	        buffReader = new BufferedReader(strReader);
	        vm = new SimpleVM(buffReader);
	    }
	    catch (IOException e) 
	    {
	    	// do nothing
		}
	        
	    // execute the program
	    vm.run();
	        
	    try 
	    {
	    	// program's symbol table should be empty
	        vm.getValue("x");
	    }
	    catch (RuntimeException e) 
	    {
	    	flag = true;
		}
	    assertTrue(flag);
	    
	    // Test on a simple (correct) program
	    flag = false;
	    try 
	    {
	    	// load the simple vm program
	        strReader = new StringReader("push 5\npop answer");
	        buffReader = new BufferedReader(strReader);
	        vm = new SimpleVM(buffReader);

	        // execute the program
	        vm.run();
	        assertEquals(5, vm.getValue("answer"));
	        flag = true;
	    } 
	    catch (IOException e) 
	    {
	        // do nothing
	    }
	    assertTrue(flag);
	    
	 // Test on a simple (correct) program, but try to access a non-existent variable
	    flag = false;
	    try 
	    {
	    	// load the simple vm program
	        strReader = new StringReader("push 5\npop answer");
	        buffReader = new BufferedReader(strReader);
	        vm = new SimpleVM(buffReader);

	        // execute the program
	        vm.run();
	        assertEquals(5, vm.getValue("y"));
	        flag = true;
	    } 
	    catch (IOException e)
	    {
	    	// do nothing
	    }
	    catch (RuntimeException e) 
	    {
	        flag = true;
	    }
	    
	    assertTrue(flag);
	    
	    // continue testing ...
	}
}
