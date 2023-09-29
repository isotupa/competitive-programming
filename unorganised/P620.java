package aop.examen;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P620 {
	
	public static boolean calcula(int sumaCara1, int sumaCara2, List<Integer> numerosRestantes, int nProcesados, int it)
	{
		//Almaceno cuantos llevo procesados dentro del array. Si llego final entonces pude colocar cada numero en una cara
		if(numerosRestantes.size() == nProcesados) return true;
		
		int tamano = numerosRestantes.size();
		for(int i = it; i < tamano; i++) { //recrear un array nuevo sin el valor ya procesado yarda mucho más
			if(sumaCara1 - numerosRestantes.get(i) >= 0) { //Puedo añadirlo a la cara 1?
				if(calcula(sumaCara1 - numerosRestantes.get(i), sumaCara2, numerosRestantes, nProcesados+1, i+1)) return true;
			}
			
			if(sumaCara2 - numerosRestantes.get(i) >= 0) { //No he podido añadirlo a la cara 1, así que pruebo en 2
				if(calcula(sumaCara1, sumaCara2  - numerosRestantes.get(i), numerosRestantes, nProcesados+1, i+1)) return true;
			}
		} //No entra en ninguna cara. No es válido
		return false;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			while(sc.hasNext()) {
				int lengthCara = sc.nextInt();
				int nJ = sc.nextInt();

				List<Integer> nRest = new ArrayList<Integer>(nJ);	
				int suma = 0;
				for(int i = 0; i < nJ; i++) {
					int numero = sc.nextInt();
					nRest.add(numero);
					suma += numero;
				}
			
				if(suma > lengthCara*2) {
					System.out.println("NO");
				}else {
					boolean ps = calcula(lengthCara, lengthCara, nRest, 0, 0);
					System.out.println(ps ? "SI" : "NO");		
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}


	}
}