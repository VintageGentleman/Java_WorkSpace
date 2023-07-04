package myobj;
@SuppressWarnings("unused")
public class C11_ModifierTest {
	
	public static String s1 = "ABC";
	protected static String s2 = "ABC";
	static String s3 = "ABC";
	private static String s4 = "ABC";

	public static int m11() {
		return 10;
	}
	
	protected static int m12() {
		return 10;
	}
	
	static int m13() {
		return 10;
	}
	
	private static int m14() {
		return 10;
	}
	
	public int i1 = 10;		// public   
	protected int i2 = 20;	// protected
	int i3 = 30;			// default
	private int i4 = 40;	// private
	
	public int m1() {
		return 10;
	}
	
	protected double m2() {
		return 1.1;
	}
		
	boolean m3() {
		return true;
	}
	
	private int[] m4() {
		return new int[10];
	}
	
}
