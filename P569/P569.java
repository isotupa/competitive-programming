package aop.P569;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P569 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			int nCasos = sc.nextInt();
			int mins = 0;
			int res = 0;
			
			while(nCasos > 0) {
				int tMin = sc.nextInt();
				int nTut = sc.nextInt();
				
				String x = sc.next();
				String y[] = x.split(":");
				
				int hora = Integer.parseInt(y[0]);
				int min = Integer.parseInt(y[1]);
				int dur = sc.nextInt();		
				
				if((8*60 + tMin) > (hora*60 + min)) {
					
				} else {
					res += ((hora*60 + min) - 8*60);
				}
				
				mins = hora*60 + min + dur;
				
				for(int a = 0; a < nTut-1; a++) {
					//System.out.println(mins);
					x = sc.next();
					String y1[] = x.split(":");
					
					hora = Integer.parseInt(y1[0]);
					min = Integer.parseInt(y1[1]);
					dur = sc.nextInt();		
					
					if(mins > (hora*60 + min) - tMin) {
						
					} else {
						res += (hora*60 + min) - mins;
					}
					
					
					mins = hora*60 + min + dur;
					
				}
				
				if(mins > 14*60 - tMin) {
					
				} else {
					
					//res += ((14*60 - mins)/tMin)*tMin;
					res += 14*60 - mins;
				}
				
				System.out.println(res);
				res = 0;
				mins = 0;
				
				
				nCasos--;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

}
