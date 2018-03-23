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
		allElements=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		
		for(MySet<E> values:t) {
			if(values!=null) {
			Iterator<E> it= values.iterator();
			while(it.hasNext()) {
				allElements.add(it.next());
			}}
		}
		
		HashMap<E, Integer> map = new HashMap<>(); 
		
		for (E e : allElements) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put(e, c+1); 
		}
		MySet<E> t2 = new Set2<>(); 
		for (Map.Entry<E, Integer> entry : map.entrySet())
		     if (entry.getValue() == 50) 
		        t2.add(entry.getKey());

		return t2;
	}

}
