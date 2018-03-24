//Bernardo Jr. Sein Acevedo
//844-14-8646
//Section 030
package p1MainClasses;
import java.util.ArrayList;
import java.util.Iterator;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3Solution<E> extends AbstractIntersectionFinder<E> {
	private ArrayList<E>allElements;
	public P3Solution(String name) {
		super(name);
		allElements=new ArrayList<>();
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		
		for(int k=0;k<t.length;k++) {
			for(E x:t[k]) {
				allElements.add(x);
			}
		}

		allElements.sort(null); 		
		MySet<E> t1 = new Set2();  // sets in P3's solution are of type Set2
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) {
		       c++;}
		    else { 
		       if (c == t.length) 
		          t1.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == t.length)
		    t1.add(allElements.get(allElements.size()-1));

		return t1;
	}

}
