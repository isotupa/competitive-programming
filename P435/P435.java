package aop.P435;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P435 {

	public static void main(String[] args) {
		
		int contador[] = {0,0,0,0,0,0,0,0,0,0};
		boolean es = false;
		String a;
		
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			while(sc.hasNextLine()) {
				a = sc.nextLine();
				for(int x = 0; x < a.length(); x++) {
//					System.out.println(a.charAt(x));
					contador[Character.getNumericValue(a.charAt(x))]++;
				}
				for(int x = 1; x < 10 && !es; x++) {
					if(contador[0] != contador[x]) {
						System.out.println("no subnormal");
						es = true;
					}
				}
				for(int x = 0; x < 10; x++) {
					contador[x] = 0;
				}
				
				if(es == false) {
					System.out.println("subnormal");
				}
				es = false;
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

}
