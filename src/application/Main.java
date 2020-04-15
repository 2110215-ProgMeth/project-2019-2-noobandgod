package application;

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		String[][] a = {{"aa","ab"},{"ba","bb"}};
		for(int i=0; i<2; ++i) {
			for(int j=0; j<2; ++j) {
				System.out.println(a[i][j]);
			}
		}
		
		Scanner kb = new Scanner(System.in);
		String c = kb.next();
		String[] cc = c.split(",");
		
		for (String d: cc) {
			System.out.println(d);
		}
		
		
		
	}

}
