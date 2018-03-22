package p1MainClasses;
import javax.swing.text.html.HTMLDocument.Iterator;

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
		
		  if (this.getName() == "P1") {
              Set1<Integer> setOne = (Set1<Integer>) t[0];
              for(int i=1; i<t.length; i++) {
                      for(Integer e: setOne) {
                              if(!(t[i].contains((E) e))) {
                                      setOne.remove(e);
                              }

                      }

              }
              return (MySet<E>) setOne;

      }

      if(this.getName() == "P2") {

              Set2<Integer> setTwo = (Set2<Integer>) t[0];

              for(int j=1; j<t.length; j++) {

                      for(Integer s: setTwo) {

                              if(!(t[j].contains((E) s))) {

                                      setTwo.remove(s);

                              }

                      }

              }

              return (MySet<E>) setTwo;

      }

      

      return null;

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
