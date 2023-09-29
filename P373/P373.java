package aop.P373;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P373 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			int casos = sc.nextInt();
			while(casos != 0) {
				
				long NC = sc.nextInt();
				long res = NC*NC*NC - (NC-2)*(NC-2)*(NC-2);
				
				System.out.format("%d\n", res);
				
				casos--;
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

}
