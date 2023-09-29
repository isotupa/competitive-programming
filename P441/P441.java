package aop.P441;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class P441 {

	public static void main(String[] args) {

		
		String s = "";
		
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			while(sc.hasNextLine()) {
				s = sc.nextLine();				
				
				BigInteger num = new BigInteger(s.replaceAll(".", ""));
				num.add(new BigInteger("1"));
				
				
				System.out.format("%,d", num.toString());
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

}
