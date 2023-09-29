package aop.P203;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P203 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			
		} catch (Exception e) {
			System.exit(1);
		}

	}

}

class Grafo {
	Grafo izda, dcha;
	int nodo;
	public Grafo(int nodo) {
		this.nodo = nodo;
	}
	
	public Grafo nuevo(Grafo g) {
		if(g.nodo != -1) izda = nuevo(g);
		if(g.nodo == -1) dcha = nuevo(g);
		return null;
	}
	

}