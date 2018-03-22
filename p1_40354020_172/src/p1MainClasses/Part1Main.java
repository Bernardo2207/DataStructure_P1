package p1MainClasses;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class Part1Main {


	public static void main(String[] args) throws FileNotFoundException {
		//n es el numero de companys
		//m numero de crimes en la investigacion
		//Crear un set para cada crime j.
		
		
		DataReader rd= new DataReader();
		Integer[][][] fData= (Integer[][][])rd.readDataFiles();
		
		MySet<Integer>[] theSet1= new MySet[rd.getM()*rd.getN()];
		MySet<Integer>[] theSet2= new MySet[rd.getM()*rd.getN()];
		
		Set1<Integer> theUnion1;
		Set2<Integer> theUnion2;
		int h=0;
		
		for(int j=0;j<fData[0].length;j++) {
			
			for(int i=0;i<fData.length;i++) {
				theUnion2= new Set2<Integer>();
				theUnion1= new Set1<Integer>();
				for(int k=0;k<fData[i][j].length;k++) {
					
					theUnion1.add(fData[i][j][k]);
					theUnion2.add(fData[i][j][k]);
				}
				theSet1[h]=theUnion1;
				theSet2[h]=theUnion2;
				h++;
			}
			
		}

		
		P1AndP2Solution p1= new P1AndP2Solution("P2");
		//p1.intersectSets(theSet2);
		
		
		//-----------------Make p1 and p2,p3 and p4 solutions----------------------
				P1AndP2Solution P1orP2; 
				P3Solution p3 = new P3Solution("P3");
				P4Solution p4 = new P4Solution("P4");
				
				//making an integer that has the integer value of the arg[o] given in command line
				Integer n = Integer.parseInt(args[0]);
				switch(n){
				case 1:
					//sysout for testing purpose
					System.out.println("Execute p1");
					Set1<Integer> x =new Set1<>();
					P1orP2 = new P1AndP2Solution("P1");
					System.out.println(theSet1[40]);
					P1orP2.intersectSets(theSet1);
					break;
				case 2:
					System.out.println("Execute p2 ");
					P1orP2 = new P1AndP2Solution("P2");
					P1orP2.intersectSets(theSet2);
					break;
				case 3:
				    System.out.println("Execute p3");
					p3.intersectSets(theSet2);
					break;
					
				case 4:
					System.out.println("Execute p4");
					p4.intersectSets(theSet2);
					break;
					
				default:
					System.out.println("Deffault");
					P1orP2 = new P1AndP2Solution("P1");
					P1orP2.intersectSets(theSet1);
					
					P1orP2 = new P1AndP2Solution("P2");
					P1orP2.intersectSets(theSet2);
					break;
				}
	}

	
	public void showFinalSet() {
		
	}
	
}
