package aop.P651;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P651 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))) {
			int def, del, cen, num;
			while(sc.hasNext()) {

				String[] aux = sc.nextLine().split(" ");
				def = Integer.parseInt(aux[0]);
				cen = Integer.parseInt(aux[1]);
				del = Integer.parseInt(aux[2]);

				if((def == 0) && (cen == 0) && (del == 0))break;
				
				num = Integer.parseInt(sc.nextLine());
				
				String[] pos = sc.nextLine().split(" ");
//				String[] defs = new String[def];
//				String[] cens = new String[cen];
//				String[] dels = new String[del];
				
				String[] res = new String[def+cen+del ];
				for(int i = 0; i < res.length; i++) res[i] = "";

				for(int i = 0; i < def; i++) {
					if(res[i].equals("")) {
						for(int j = 0; j < pos.length; j++) {
							if(pos[j].equals("F")) {
								res[i] = "F";
								pos[j] = "";
							}
						}
					}
				}

				for(int i = cen; i < def + cen; i++) {
					if(res[i].equals("")) {
						for(int j = 0; j < pos.length; j++) {
							if(pos[j].equals("C")) {
								res[i] = "C";
								pos[j] = "";
							}
						}
					}
				}
				
				for(int i = def + cen; i < def + cen + del; i++) {
					if(res[i].equals("")) {
						for(int j = 0; j < pos.length; j++) {
							if(pos[j].equals("D")) {
								res[i] = "D";
								pos[j] = "";
							}
						}
					}
				}
				
				for(int i = 0; i < res.length; i++) System.out.print(res[i].isEmpty() ? "_" : res[i]);
				System.out.println("");

			}
		} catch (Exception e) {
			System.exit(1);
		}


	}

	// search and return all the solutions to a given problem
	public static List<PartialSolution> allSolutions(PartialSolution problem) {

		// we store the frontier of the search tree in a stack
		Stack<PartialSolution> frontier = new Stack<PartialSolution>();
		// the initial frontier only contains the problem given
		frontier.add(problem);

		// we will store the solutions found in a list
		List<PartialSolution> sols = new ArrayList<PartialSolution>();

		// tree traversal
		PartialSolution current;
		// the exit condition is that the frontier is empty
		while (!frontier.isEmpty()) {
			// we know that there is some element
			// we look at the top element
			current = frontier.peek();
			frontier.pop();
			// if it is not valid, just remove it (do nothing)
			if (current.isValid()) {
				if (current.isFinal()) {
					// if it is valid and final, it is a solution
					// add it to sols
					sols.add(current);
				} else {
					// if it is not final, expand it
					List<PartialSolution> nextones = current.successors();
					// and add the successors to the frontier
					Iterator<PartialSolution> cursor = nextones.iterator();
					while (cursor.hasNext()) {
						frontier.push(cursor.next());
						cursor.remove();
					}
				}
			}
		}
		// no more states to explore => return solutions found
		return sols;
	} // END allSolutions 

}

class PartialSolution {
	
	String[] a;
	
	public PartialSolution(String[] a) {
		this.a = a;
	}

    // if a state is not valid it should not be further
    // explored and can be discarded
    public boolean isValid() {
    	for(int i = 0; i < a.length; i++) {
    		//if(a[i].contains(""))
    	}
    	return true;
    }

    // if a state is valid and final then it is
    // considered a solution
    public boolean isFinal() {
    	return true;
    }

    // states which are valid but not final
    // must be further developed in order to
    // find a solution
    public List<PartialSolution> successors() {
    	return null;
    }
}
