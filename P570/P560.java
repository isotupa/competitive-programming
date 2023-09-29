package aop.P570;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P560 {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			int nCasos = sc.nextInt();
			
			char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
			int pos1 = -1;
			int pos2 = -1;
			
			while(nCasos > 0) {
				String dni = sc.nextLine();
				int interr = 0;
				int suma = 0;
				
				
				char letra = dni.charAt(dni.length());
				int index = 0;
				
				for(int a = 0; a < letras.length; a++) {
					if(letras[a] == letra) {
						index = a;
						break;
					}
				}
				
				
				for(int a = 0; a < dni.length()-1; a++) {
					
					char x = dni.charAt(a);
					if(x == '?') {
						interr++;
						
					} else {
						suma += x-'0';
					}
				}
				
				
				System.out.format("%d\n");
				
				nCasos--;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

}
