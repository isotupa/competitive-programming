package aop.P396;

import java.util.Scanner;

public class P396 {

	public static void main(String[] args) {

		int numPartituras, numInstrumentos, numMayor = 0, index = 0;

		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				numPartituras = sc.nextInt();
				numInstrumentos = sc.nextInt();
				
				int[] array = new int[numPartituras];
//				int[] array = new int[200000];

				for(int i = 0; i < numInstrumentos; i++) {
					array[i] = sc.nextInt();
					if(numMayor < array[i]) {
						numMayor = array[i];
						index = i;
					}
				}

				numPartituras -= numInstrumentos;

				do {
					if(numPartituras != 0) {

						if(numMayor%2 != 0) {
							array[index] = (numMayor/2)+(numMayor%2);
							array[array.length-numPartituras] = numMayor/2;
						}
						else {
							array[index] = numMayor/2;
							array[array.length-numPartituras] = numMayor/2;
						}
					}
					
					numMayor = 0;

					for(int i = 0; i < array.length && array[i] != 0; i++) {
						if(numMayor < array[i]) {
							numMayor = array[i];
							index = i;
						}
					}

					numPartituras--;
				}
				while(numPartituras > 0);

				System.out.println(numMayor);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}


	}

}
