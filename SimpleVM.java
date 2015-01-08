import java.io.BufferedReader;
import java.io.IOException;

/**
 * Load, parse, compile, and run the simple VM code.
 * 
 * @author <fill in here>
 * @version <fill in here>
 */

public class SimpleVM
{   
	// insert instance variable(s) here, if any
	
    /**
     * Creates a SimpleVM with the program contained in 
     * the supplied BufferedReader.
     * 
     * @param reader the BufferedReader containing the program
     * @throws IOException if the program has syntax errors
     */
    public SimpleVM(BufferedReader reader) throws IOException
    {
    }

    /**
     * Runs the loaded program.
     * 
     * @throws RuntimeException if the program execution encounters run-time errors
     */
    public void run()
    {
    }
    
    /**
     * Returns the value of the given variable.
     * 
     * @param name the variable name
     * @return the value
     * @throws RuntimeException if the variable is not defined
     */
    public int getValue(String name)
    {
        return 0;
    }
}