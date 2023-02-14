package recurssion;

public class Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean ans = exist(board, word);
		System.out.println(ans);
	}

	public static boolean exist(char[][] board, String word) {
		boolean result = false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==word.charAt(0))
					result = isPresent(board, word, i, j, visited);
				if(result==true)
					return true;
			}
		}
		
		return false;
	}

	private static boolean isPresent(char[][] board, String word, int row, int col, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(word.length()==0)
			return true;
		
		if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(0))
		{
			return false;
		}
		
		
		boolean r = false, l = false, u = false, d = false;
		if(visited[row][col] != true)
		{		
			visited[row][col] = true;
			d = isPresent(board, word.substring(1), row+1, col, visited);
			u = isPresent(board, word.substring(1), row-1, col, visited);
			r = isPresent(board, word.substring(1), row, col+1, visited);
			l = isPresent(board, word.substring(1), row, col-1, visited);
			
			visited[row][col] = false;
		}
		
//		System.out.println(r+" "+l +" "+u +" "+d);
		return r||l||d||u;
	}

}
