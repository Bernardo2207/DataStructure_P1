package mySetImplementations;

public class StrategiesTimeCollection<E> {
private int n,m,isize,fsize,istep,rep,sum;
private long startTime;
private long endTime;
	public StrategiesTimeCollection( int n,int  m,int  isize,int  fsize ,int istep,int  rep) {
		this.n=n;
		this.m=m;
		this.isize=isize;
		this.fsize=fsize;
		this.istep=istep;
		this.rep=rep;
	}
	public void runTrial(StrategiesTimeCollection<E> dataSet) {}
	public int resetSum() {
		return sum=0;
	}
	public void incSum(int estimated) {}
	public long averageTime() {return 0;}
	public void add() {}
	public int getSum() {return sum;}
}
