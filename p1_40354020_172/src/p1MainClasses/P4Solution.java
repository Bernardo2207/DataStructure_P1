package p1MainClasses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P4Solution<E> extends AbstractIntersectionFinder<E> {
	private ArrayList<E>allElements;
	public P4Solution(String name) {
		super(name);
		//Initialize ArrayList to contain AllElements in the set
		allElements=new ArrayList<>();
		
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		//Adds al ellements in t[i] to the ArrayList allElements.
		for(int k=0;k<t.length;k++) {
			for(E x:t[k]) {
				allElements.add(x);
			}
		}
		//Initializes HashaMap map to store elements and its frequency.
		HashMap<E, Integer> map = new HashMap<>(); 
		
		for (E e : allElements) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put(e, c+1); 
		}
		MySet<E> t2 = new Set2<>(); 
		for (Map.Entry<E, Integer> entry : map.entrySet())
		     if (entry.getValue() == t.length) 
		        t2.add(entry.getKey());

		return t2;
	}

}
