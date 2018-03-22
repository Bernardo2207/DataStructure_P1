package p1MainClasses;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class Part1Main {

//
//static int totalSize = 200; 
//static int n = 20, m = 10; 
//static Set1<Integer> theSet1=new Set1<>();
//static Set2<Integer> theSet2=new Set2<>();

	public static void main(String[] args) throws FileNotFoundException {
		//n es el numero de companys
		//m numero de crimes en la investigacion
		//Crear un set para cada crime j.
		
		
		DataReader rd= new DataReader();
		Integer[][][] fData= (Integer[][][])rd.readDataFiles();
		
		MySet<Integer>[] theSet= new MySet[rd.getM()];
		
		MySet<Integer> theUnion;
		
		for(int j=0;j<fData[0].length;j++) {
			theUnion= new Set2<Integer>();
			for(int i=0;i<fData.length;i++) {
				for(int k=0;k<fData[i][j].length;k++) {
					theUnion.add(fData[i][j][k]);
				}
			}
			theSet[j]=theUnion;
		}
		System.out.println(theSet);
		P3Solution p1= new P3Solution("P2");
		p1.intersectSets(theSet);
		System.out.println(p1.intersectSets(theSet));
		
		//p1.intersectSets(theSet);
//		DataGenerator dg = new DataGenerator(n, m, totalSize);
//		Object[][][] data=dg.generateData();
//		dg.printSizes();
//		dg.printSets();
		
		//PRIMER PASO, BUSCAR LA UNION DE TODOS LOS NUMEROS DE UN CRIMEN J!!
		
		
		
		
		
		//Set2<Integer>[] mySet2= (Set2<Integer>[])theSet2.toArray();
		//p1P2.intersectSets(mySet1);
		//p1P2.intersectSets(mySet2);
//		Union of Sets.
//		for (int i=0; i<n; i++)
//			for (int j=0; j<m; j++) { 
//				save(((Integer[]) data[i][j])); 
//			}
//		MySet<Integer>[] w= new MySet[theSet1.size()];
//		
//		System.out.println(theSet1.toString());
//		System.out.println(theSet2.toString());
//		
		//		Set1<Integer>[] mySet1 = new Set1[n*m];
//		theSet1.toArray(mySet1);
//		
//		Set2<Integer>[] mySet2 = new Set2[n*m];
//		theSet1.toArray(mySet1);
//		
//		for(int i=0;i<mySet2.length;i++) {
//			System.out.println(mySet2[i]);
//		}
			}
	//
//	public static void save(Integer[] t) {
//		for(int i=0;i<t.length;i++) {
//			if(!(theSet1.contains(t[i]))) {
//			theSet1.add(t[i]);
//			}
//			if(!(theSet2.contains(t[i]))) {
//				theSet2.add(t[i]);
//				}
//		}
//	}
	
//	public static void print(Integer[] t) {
//		for(int i=0;i<t.length;i++)
//		System.out.println(t[i]);
//	}

	
	public void showFinalSet() {
		
	}
	
}
