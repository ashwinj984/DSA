// https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

class Solution
{
     static char keypad[][] = {{'1','2','3'},
                        {'4','5','6'},
                        {'7','8','9'},
                        {'*','0','#'}}; 
	public long getCount(int n)
	{
	    int row[] = {0, 0, -1, 0, 1};
        int col[] = {0, -1, 0, 1, 0};
		long[][] count = new long[10][n + 1];
		for(int i = 0; i < count.length; i++){
		    count[i][0] = 0;
		    count[i][1] = 1;
		}
		int i = 0, j = 0, k = 0, move = 0,ro = 0,co = 0, num = 0;
		int nextNum = 0;
		long totalCount = 0;
		for(k = 2; k < n + 1; k++){
		    for( i = 0; i < 4; i++){
		        for( j = 0; j < 3; j++){
		            if(keypad[i][j] != '*' && keypad[i][j] != '#'){
		                num = keypad[i][j] - '0';
		                count[num][k] = 0;
		                
		                for(move = 0; move < 5; move++){
		                    ro = i + row[move];
		                    co = j + col[move];
		                    if(ro >= 0 && ro <= 3 && co >= 0 && co <= 2 && keypad[ro][co] != '*' &&
		                        keypad[ro][co] != '#'){
		                            nextNum = keypad[ro][co] - '0';
		                            count[num][k] += count[nextNum][k - 1];
		                        }
		                }
		            }
		        }
		    }
		}
		totalCount = 0;
		for(i = 0; i < 10; i++){
		    totalCount += count[i][n];
		}
		return totalCount;
	}
}
