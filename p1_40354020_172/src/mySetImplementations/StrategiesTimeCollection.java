package mySetImplementations;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import p1MainClasses.P1AndP2Solution;

public class StrategiesTimeCollection<E>extends ArrayList<Map.Entry<Integer, Float>>  {
private int n,m,isize,fsize,istep,rep;
private long startTime;
private long endTime;
private float sum;
private IntersectionFinder<Integer> strategy;  
String name;

//	public StrategiesTimeCollection( int n,int  m,int  isize,int  fsize ,int istep,int  rep) {
//		this.n=n;
//		this.m=m;
//		this.isize=isize;
//		this.fsize=fsize;
//		this.istep=istep;
//		this.rep=rep;
//		
//	}
	public StrategiesTimeCollection(IntersectionFinder<Integer> p) {
		name=p.getName();
		strategy=p;
		
		// TODO Auto-generated constructor stub
	}
	public void runTrial(MySet<Integer>[] data) { 
    	strategy.intersectSets(data);
    }
	 public String getStrategyName() { 
	        return name; 
	    }
	    
	   
	    
	    public void resetSum() { 
	    	sum = 0.0f; 
	    }
	    
	    public void incSum(float t) { 
	    	sum += t; 
	    }
	    
	    public float getSum() { 
	    	return sum; 
	    }
}
