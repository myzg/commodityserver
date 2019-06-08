package test;

import org.json.JSONObject;

public class test {
	public int i =-1;
	
	public static void main(String [] args ){
		test tt = new test();
		add(tt);
		add(tt);
		add(tt);
		add(tt);
		add(tt);
		add(tt);
		System.out.println(tt);
	}
	
	public static void add(test tt) {
		tt.i++;
	}

	@Override
	public String toString() {
		return "test [i=" + i + "]";
	}
	
}
