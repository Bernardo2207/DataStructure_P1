package mySetImplementations;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.MySet;

/**
 * This class represents an object data type that is able to carry the 
 * necessary experiments to estimate execution times of particular 
 * strategies to solve the set intersections problem as in p1_40354020_172. 
 * 
 * @author pedroirivera-vega
 *
 */
public class ExperimentController{
	private int n=10;
	private int m=50;
	private int initialSize=1000;           // initial size to be tested
	private int repetitionsPerSize=200;    // experimental repetitions per size
	private int incrementalSizeStep=100;   // change of sizes (size delta)
	private int finalSize=50000;             // last size to be tested
	
	private ArrayList<StrategiesTimeCollection<Integer>> resultsPerStrategy; 
	// The i-th position will contain a particular strategy being tested. 
	// At the end, the i-th position will also contain a list of 
	// pairs (n, t), where t is the estimated time for size n for
	// the strategy at that position. 
	
	public ExperimentController(int In, int Im, int is, int fs, int iss, int rps) { 
		n = In;
		m = Im;
		initialSize = is; 
		repetitionsPerSize = rps; 
		incrementalSizeStep = iss; 
		finalSize = fs; 
		resultsPerStrategy = new ArrayList<>(); 
		
        //JPanel pane = new JPanel();      // this was intended for a progress bar....
        //pane.setLayout(new FlowLayout());

	}
	
	public void addStrategy(StrategiesTimeCollection<Integer> strategy) { 
		resultsPerStrategy.add(strategy); 
	}

	public void run() throws CloneNotSupportedException { 
		if (resultsPerStrategy.isEmpty())
			throw new IllegalStateException("No strategy has been added."); 
		for (int size=initialSize; size<=finalSize; size+=incrementalSizeStep) { 
			// For each strategy, reset the corresponding variable that will be used
			// to store the sum of times that the particular strategy exhibits for
			// the current size size
			for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) 
				strategy.resetSum();  
			
			// Run all trials for the current size. 
			for (int r = 0; r<repetitionsPerSize; r++) {
				// The following will be the common dataset to be used in the current 
				// trial by all the strategies being tested.
				//Integer[][][] data = generateData(size);  
				DataGenerator x= new DataGenerator(n,m,size);
				
				
				Integer[][][] fData= (Integer[][][])x.generateData();
				
				MySet<Integer>[] theSet1= new MySet[m];
				MySet<Integer>[] theSet2= new MySet[m];
				
				Set1<Integer> theUnion1;
				Set2<Integer> theUnion2;
				
				
				for(int j=0;j<fData[0].length;j++) {
					theUnion2= new Set2<Integer>();
					theUnion1= new Set1<Integer>();
					for(int i=0;i<fData.length;i++) {
						for(int k=0;k<fData[i][j].length;k++) {					
							theUnion1.add(fData[i][j][k]);
							theUnion2.add(fData[i][j][k]);
						}
					}
					theSet1[j]=theUnion1;
					theSet2[j]=theUnion2;
				}
				
				// Apply each one of the strategies being tested using the previous 
				// dataset (of size size) as input; and, for each, estimate the time
				// that the execution takes. 
				for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) {  
					// no need to clone the data set to be used by each strategy since
					// no modification of it is done in the process...
					long startTime = System.nanoTime(); // System.currentTimeMillis();   // time before
					if (strategy.getStrategyName() == "P1"){
					strategy.runTrial(theSet1);   // run the particular strategy if uses set 1...
					}
					else if(strategy.getStrategyName() == "P2" || 
							strategy.getStrategyName() == "P3" ||
							strategy.getStrategyName() == "P4")
						strategy.runTrial(theSet2);	// run the particular strategy if uses set 2
					
					long endTime = System.nanoTime(); // System.currentTimeMillis();    // time after

					// accumulate the estimated time (add it) to sum of times that
					// the current strategy has exhibited on trials for datasets
					// of the current size. 
					strategy.incSum((int) (endTime-startTime));    
					
				}
			}
			
			for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) { 
				strategy.add(new AbstractMap.SimpleEntry<Integer, Float>
				(size, (strategy.getSum()/((float) repetitionsPerSize)))); 
			}

			System.out.println(size); 

		}
	}
	
	private Integer[][][] generateData(int size) {
		DataGenerator dg = new DataGenerator(20,20,size);
		Integer[][][] data = (Integer[][][])dg.generateData();  

		return data;
	}

	public void saveResults() throws FileNotFoundException { 
		
		PrintStream out = new PrintStream(new File("experimentalResults", "allResults.txt"));
		out.print("Size");
		for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy) 
			out.print("\t" + trc.getStrategyName()); 
		out.println();

		int numberOfExperiments = resultsPerStrategy.get(0).size(); 
		for (int i=0; i<numberOfExperiments; i++) {
			out.print(resultsPerStrategy.get(0).get(i).getKey());
			for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy)
				out.print("\t" + trc.get(i).getValue());
			out.println(); 
		}
			
		out.close();
		
	}
}


