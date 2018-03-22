package p1MainClasses;
import java.util.ArrayList;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3Solution<E> extends AbstractIntersectionFinder<E> {

	public P3Solution(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		
		ArrayList<E>allElements=new ArrayList<>();
		allElements.sort(null); 		
		MySet<E> t1 = new Set2();  // sets in P3's solution are of type Set2
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == 40) 
		          t1.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == 40)
		    t1.add(allElements.get(allElements.size()-1));

		return null;
	}

}
