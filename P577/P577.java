package aop.P577;

import java.io.BufferedInputStream;
import java.util.Scanner;

//id Usuario: 26362
public class P577 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int nCasos = sc.nextInt();
			for (int i = 0; i < nCasos; ++i) {
				int min = sc.nextInt();
				int max = sc.nextInt();
				int real = sc.nextInt();
				int contador = 1;
				
				for(int a = 0; a < max; ++a) {
					if(min + a < real) contador++;
					
				}
				
				System.out.println(contador);
			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

}