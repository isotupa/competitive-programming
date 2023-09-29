package aop.P224;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P224 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			boolean bool = false, b = false;

			while(sc.hasNext()) {
				int nCasos = sc.nextInt();
				if(nCasos == 0) break;
				int[] array = new int[nCasos];
				
				for(int i = 0; i < nCasos; i++) {
					array[i] = sc.nextInt();
				}
				
				for(int i = 0; i < nCasos; i++) {
					int suma = 0;
					bool = b = false;
					for(int j = i+1; j < nCasos && !bool; j++) {
						suma += array[j];
						if(suma > array[i]) bool = true;
						
					}
					if(suma == array[i] && !bool) {
						System.out.println("SI " + (i+1));
						b = true;
						break;
					}
				}
				if(!b) System.out.println("NO");

			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

}
