//Bernardo Jr. Sein Acevedo
//844-14-8646
//Section 030
package p1MainClasses;
import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1AndP2Solution<E> extends AbstractIntersectionFinder<E> {
	MySet<E> testSet;
	public P1AndP2Solution(String name) {
		super(name);
		
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {	
		//We clone t[0] to preserve the content of the original t set.
				try {
					testSet = (MySet<E>)t[0].clone();
				} catch (CloneNotSupportedException e) {e.printStackTrace();
				}			
				//Here we verify if the content on t[0] is present if sets t[i].
				//if not, we remove it from the list testSet.
				for(int i=0;i<t.length;i++) 
					for(E x:t[0]) {
						if(!t[i].contains(x)) {
							testSet.remove(x);
						}
					}
		      return testSet;
	}
}
