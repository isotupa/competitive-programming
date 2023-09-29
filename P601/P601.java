package aop.P601;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P601 {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024));
		
		FastReader s = new FastReader();

		while(s.hasNext()) {
			int N = s.nextInt();
			int S = s.nextInt();
			int T = s.nextInt();
			int P = s.nextInt();

			int[][] matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = -1;
				}
			}
			boolean unico = true;
			for(int i = 0; i < P; i++) {
				int celda1 = s.nextInt();
				int celda2 = s.nextInt();
				int t = s.nextInt();

				matrix[celda1-1][celda2-1] = t;
				
			}
			for(int i = 0; i < N; i++) {
				if(matrix[S-1][i] != -1) unico = false;
			}
			
			int res = 0;
			if(unico == false) {
				
				for(int i = 0; i < N; i++) {
					if(i != (S-1)) {
						GraphState q = new GraphState(matrix,i,S-1,T);
						PartialSolutionCost route = BestFirst.firstSolution(q);
						if(route == null) break;
						if(((GraphState)route).show()<= T) res++;
						//					System.out.print("\n");
					}
				}
			}
			System.out.println(res);
			//			System.out.println("--------------");

			//System.out.println(num);
		}

	}

	// first, we define a class to model graph search
	public static class GraphState implements PartialSolutionCost {

		// we need a (directed) graph
		// for the moment, an array will suffice
		public int[][] graph;

		// the following are sets of vertices
		public boolean[] visited;

		// start and destination of our trip
		public int start, end;

		// distance travelled
		public int distance;

		// path so far
		public ArrayList<Integer> route;
		
		private int T;

		// constructor
		public GraphState(int[][] graph, int start, int end, int T) {
			this.graph = graph; // just a ref -- graph is read-only
			this.start = start;
			this.end   = end;
			this.route = new ArrayList<Integer>();
			this.T = T;
			// route is never empty -- it always contains the starting point
			// do this only the first time:
			if (this.route.size() == 0) {
				this.route.add(start);
				// the starting point has been "visited"
				this.visited = new boolean[this.graph.length];
				this.visited[start] = true; // the others should be false
			}
		}

		// PartialSolution interface
		// all routes are valid
		public boolean isValid() {
			return true;
		}

		// a route is final when it reaches the endpoint
		public boolean isFinal() {
			int size = this.route.size();
			return this.end == this.route.get(size-1);
		}

		// we extend a route by adding neighbours
		// of the last node visited
		public List<PartialSolutionCost> successors() {
			int routesize = this.route.size();
			int lastnode = this.route.get(routesize-1);

			// the successors will be stored in nextones
			ArrayList nextones = new ArrayList<GraphState>();

			// we obtain the number of nodes
			int graphsize = this.graph.length;
			// arcs are nonnegative positions in the graph matrix

			// we look for neighbors of the lastnode that have
			// not been visited before
			for (int i = 0; i < graphsize; i++) {
				if (this.graph[lastnode][i] > 0 &&
						!this.visited[i]) {
					GraphState next = new GraphState(this.graph,this.start,this.end,T);
					// overwrite next's route :(
					next.route = new ArrayList<Integer>();
					// we copy our current route to the new route...
					for (int j = 0; j < routesize; j++) {
						next.route.add(this.route.get(j));
					}
					// ...and add the new visited
					next.route.add(i);

					// we copy our visited set to the new state...
					for (int j = 0; j < graphsize; j++) {
						next.visited[j] = this.visited[j];
					}
					// ...and we add the new node visited
					next.visited[i] = true;

					// we deliver the new state
					nextones.add(next);
				}
			}	    

			// return successors
			return nextones;
		}

		// Comparable interface
		// the cost is the length of the current route
		private int cost() {
			// initialize length to 0
			int length = 0;
			

			// the route is never empty
			// it contains at least the starting point
			int size = this.route.size();
			for (int i = 0; i < size-1; i++) {
				length += this.graph[route.get(i)][route.get(i+1)];
			}
			if(length > T) return Integer.MAX_VALUE;
			return length;
		}

		// we compare according to cost
		public int compareTo(Object o) {
			// o must be another GraphState
			int mine = this.cost();
			int his  = ((GraphState)o).cost();

			if (mine < his) {
				return -1;
			} else if (mine > his) {
				return 1;
			} else {
				return 0;
			}
		}

		// Showable??
		public int show() {
			// print starting point
			//			System.out.print(P601.pretty(this.start));
			int routesize = this.route.size();

			// print the rest of the nodes
//			for (int i = 1; i < routesize; i++) {
//				//				System.out.print(" - " + (P601.pretty(this.route.get(i))));
//			}

			// print length
			int length = 0;
			for (int i = 0; i < routesize - 1; i++) {
				length += this.graph[this.route.get(i)][this.route.get(i+1)];
			}
			//			System.out.printf(" ( %d )", length);
			return length;
		}
	}

	// dirtyprinting
	public static String pretty(int index) {
		String[] letters =
				new String[] {"0","1","2","3","4","5","6"};
		return letters[index];
	}
}

interface PartialSolutionCost extends Comparable {

	// if a state is not valid it should not be further
	// explored and can be discarded
	public boolean isValid();

	// if a state is valid and final then it is
	// considered a solution
	public boolean isFinal();

	// states which are valid but not final
	// must be further developed in order to
	// find a solution
	public List<PartialSolutionCost> successors();

}

class BestFirst {

	// search and return the first solution to a given problem
	public static PartialSolutionCost firstSolution(PartialSolutionCost problem) {

		// we store the frontier of the search tree in a priority queue,
		// according to cost
		PriorityQueue<PartialSolutionCost> frontier = new PriorityQueue<PartialSolutionCost>();
		// the initial frontier only contains the problem given
		frontier.add(problem);

		// tree traversal
		PartialSolutionCost current;
		// the exit condition is that the frontier is empty
		while (!frontier.isEmpty()) {
			// we know that there is some element
			// we look at the front element
			// this is, by definition, the best one, i.e.,
			// that with the lesser cost
			current = frontier.poll();
			// if it is not valid, just remove it (do nothing)
			if (current.isValid()) {
				if (current.isFinal()) {
					// if it is valid and final, it is a solution
					// return it
					return current;
				} else {
					// if it is not final, expand it
					List<PartialSolutionCost> nextones = current.successors();
					// and add the successors to the frontier
					Iterator<PartialSolutionCost> cursor = nextones.iterator();
					while (cursor.hasNext()) {
						frontier.add(cursor.next());
						cursor.remove(); // necessary?
					}
				}
			}
		}
		// this should throw an exception...
		return(null);
	} // END firstSolution

}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    boolean hasNext() {
    	return st == null || !st.hasMoreElements();
    }

    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}