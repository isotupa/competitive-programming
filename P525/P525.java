package aop.P525;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P525 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int nCasos = sc.nextInt();
			for (int i = 0; i < nCasos; ++i) {
				int t1 = sc.nextInt();
				int t2 = sc.nextInt();
				int t3 = sc.nextInt();
				int t4 = sc.nextInt();
				
//				int min1 = (t1 < t2 ? t2 :t1);
//				int max1 = (t1 > t2 ? t1 :t2);
//				int min2 = (t3 < t4 ? t3 :t4);
//				int max2 = (t3 > t4 ? t3 :t4);
				
				int min1 = Math.min(t1,t2);
				int max1 = Math.max(t1,t2);
				int min2 = Math.min(t3,t4);
				int max2 = Math.max(t3,t4);
				
				if(max2 <= min1) System.out.println("SEPARADOS");
				else if(min1 >= max2) System.out.println("SEPARADOS");
				else System.out.println("SOLAPADOS");
				
//				if(min2 <= min1 && max2 > min1) System.out.println("SOLAPADOS");
//				else if((min1 < min2 && min2 < max1) && max2 > min1 ) System.out.println("SOLAPADOS");
//				else System.out.println("SEPARADOS");
			
			}
		} catch (Exception e) {
			System.exit(1);
		}

	}

}
