package aop.P304;

import java.io.*;
import java.util.*;

public class P304 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			
			int nCasos = sc.nextInt();
			
			while(nCasos > 0) {
				int dividendo = sc.nextInt();
				int divisor = sc.nextInt();
				
				if(divisor == 0) {
					System.out.println("DIV0");
				} else if(dividendo == 0) {
					System.out.println("0 0");
				} else if(dividendo > 0 && divisor > 0) {
					int cociente = dividendo / divisor;
					int resto = dividendo % divisor;
					System.out.println(cociente + " " + divisor);
					assert resto >= 0 : "El resto < 0";
					assert dividendo == cociente * divisor + resto : "No está bien";
				} else {
					int cociente = dividendo / divisor;
					int resto = dividendo % divisor;
					System.out.println(cociente + " " + divisor);
					assert resto >= 0 : "El resto < 0";
					assert dividendo == cociente * divisor + resto : "No está bien";
				}
				
				--nCasos;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

}
