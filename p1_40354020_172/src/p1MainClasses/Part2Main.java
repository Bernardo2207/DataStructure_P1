package p1MainClasses;

import java.io.FileNotFoundException;

import mySetImplementations.ExperimentController;
import mySetImplementations.StrategiesTimeCollection;

public class Part2Main {

							     //n m isize fsize istep rep
	private static int[] parms = {10, 15, 100, 100000,3000,10};
	// min size, max size, size increment, number of trials per size/strategy
	
	public static void main(String[] args) throws CloneNotSupportedException {
		if (args.length > 4)
			System.out.println("Unexpected number of parameters. Must me <= 4.");
		for (int i=0; i<args.length; i++)
			parms[i] = Integer.parseInt(args[i]); 
		
		// Parm1: initial size
		// Parm2: final size to consider
		// Parm3: incremental steps (size)
		// Parm4: trials per size
		ExperimentController ec = new ExperimentController(parms[0], parms[1], parms[2], parms[3],parms[4],parms[5]); 
		
		/**/	
	    ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1AndP2Solution<Integer>("P1")));
	    ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1AndP2Solution<Integer>("P2")));
	    ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3Solution<Integer>("P3")));
	    ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4Solution<Integer>("P4")));

		/**/

		ec.run();    // run the experiments on all the strategies added to the controller object (ec)
		
		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
