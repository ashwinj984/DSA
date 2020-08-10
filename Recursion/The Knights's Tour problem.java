import java.util.*;
public class KnightsBackTracking {
	static int N = 8;

	public static void main(String[] args) {
		// This is just a driver function
		SolveKnights();
	}
	public static void SolveKnights() {
		// Initialisation of the Array
		int[][] solution = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				solution[i][j] = -1;
			}
		}
		// First element will be 0
		solution[0][0] = 0;
		// Taken help from Geeks for geeks for this line :( :( :(
		 int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
	        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
	       // kind of base case
		if(solveKnights(0,0,1,solution,xMove,yMove) == 0)
			// if result is not true just print 
			System.out.println("Solution Does not exist");
		else
			// for printing of the answer
			printres(solution);
	}
	static int solveKnights(int x,int y,int moves,int[][] solution,int[] xMove,int[] yMove) {
		// base case because we are starting from 0 it will go upto N*N - 1
		if(moves == N*N)
			return 1;
		// running a loop to check all the possible places where we can place our next move
		for(int k = 0; k < N; k++) {
				int next_x = x + xMove[k];
				int next_y = y + yMove[k];
				// checking that if another move is already places there or not
				if(isSafe(next_x,next_y,solution) == true)
				{	
					// if not placed place it there and check for next move
					solution[next_x][next_y] = moves;
					if(solveKnights(next_x,next_y,moves+1,solution,xMove,yMove) == 1)// Recursion
						return 1;
					else
						// else backtrack
						solution[next_x][next_y] = -1;
				}
		}
		 return 0;
		
	}
	public static boolean isSafe(int next_x,int next_y,int[][] solution) {
		// checking the boundary condition
		return (next_x >= 0 && next_x< N && next_y >= 0 && next_y < N && solution[next_x][next_y] == -1);
	}
	// a simple function to print all the results if true
	public static void printres(int[][] solution) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(solution[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
// Use of backtracking
