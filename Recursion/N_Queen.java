import java.util.*;
public class N_Queen {
	public static boolean N_queen1(int[][] a, int n,int rows) {
		if(rows == n)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j  < n; j++)
				{
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		for(int i = 0; i < a.length; i++)
		{
			//int count = 0;
			if(check(a,rows,n,i) == true) {
				a[rows][i] = 1;
			
			boolean agli_Queen_kai_liye_check_kar = N_queen1(a,n,rows+1);
			if(agli_Queen_kai_liye_check_kar == true) {
				return true;
			}
			}
			
			// agli queen agar nhi rakh paye to pahli wali ko change karo
			a[rows][i] = 0;
		}
		return false;
		}
		public static boolean check(int boards[][], int rows,int n, int col) {
			//check for row
			for(int l = 0; l < n; l++) {
				if(boards[rows][l] == 1) {
					return false;
				}
			}
			// check for columns
			for(int l = 0; l < n; l++) {
				if(boards[l][col] == 1)
					return false;
			}
			//check for left diagonals
			int i = rows;
			int j = col;
			while(i>=0 && j>=0)
			{
				if(boards[i][j] == 1)
					return false;
				i--;
				j--;
			}
			// check for right diagonal
			 i = rows;
			 j = col;
			 while(i>=0 && j<n)
			 {
				 if(boards[i][j] == 1)
					 return false;
				 i--;
				 j++;
			 }
			 return true;
			
		}
		
	

	public static void main(String[] args) {
		int[][] boards = new int[2][2];
		if(N_queen1(boards,2,0) == false)
			System.out.println("Queen cannot be fitted without attack");
		}

	}


