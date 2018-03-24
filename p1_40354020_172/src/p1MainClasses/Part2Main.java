package p1MainClasses;

import java.io.FileNotFoundException;

import mySetImplementations.ExperimentController;
import mySetImplementations.StrategiesTimeCollection;

public class Part2Main {


	private static int[] parms = {50, 1000, 50, 200};
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
		ExperimentController ec = new ExperimentController(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5])); 
		
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
