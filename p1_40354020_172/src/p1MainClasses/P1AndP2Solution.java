package p1MainClasses;
import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1AndP2Solution<E> extends AbstractIntersectionFinder<E> {
	
	public P1AndP2Solution(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		//Part1Main.list
		
		MySet<E> testSet;
		
				if(this.getName() == "P1")
					testSet = new Set1<E>();
				else if(this.getName() == "P2")
					testSet = new Set2<E>();
				testSet = t[0];
				//Iterator<E> x= new Iterator<>();
				Iterator<E> it=testSet.iterator();
				
				for(int i=0;i<t.length;i++) {
				while((it).hasNext()) {
					if(!t[i].contains(it.next())) {
						it.remove();}}
				}

		      return testSet;
}
		
		
		
		
		
//		MySet<E> problem;
//		if(getName()=="P1") 
//			problem=new Set1<E>();
//		else
//			problem= new Set2<E>();
//		
//		for(MySet<E> e: t) {
//			problem.add(e);
//		}
//		for(int i=1;i<t.length;i++) {
//			Iterator iter= problem.iterator();
//			while(iter.hasNext())
//				if(!(t[i].contains(iter.next())){
//					iter.remove();
//				}
//		}
//		
//
//		
//		return problem;
//	}

}
