package aop.P350;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P350 {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			while(!(a == 0 && b == 0)) {
				System.out.println(String.format("%4d, %4d", a, b));
				
				a = sc.nextInt();
				b = sc.nextInt();
			}
		} catch (Exception e) {
			System.exit(1);
		}

	}

}
