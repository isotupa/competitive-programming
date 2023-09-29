package aop.P622;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P622 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int n = sc.nextInt();
			while(n != 0) {
				int b = 0;
				for(int i = 0; i < n; ++i) {
					b += sc.nextInt();
				}
				int t = sc.nextInt();
				
				int a =((n+1)*t)-b;
				
				if(a <= 10 && a >= 0) System.out.println(a);
				//else if(a < 0) System.out.println("IMPOSIBLE");
				else System.out.println("IMPOSIBLE");
				
				n = sc.nextInt();
			}
			
			
			
		} catch (Exception e) {
			System.exit(1);
		}


	}

}
