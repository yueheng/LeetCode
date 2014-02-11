/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
//dfs, stack overflow
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m-1][j] == 'O') dfs(board, m-1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '+') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j) {
        board[i][j] = '+';
        int m = board.length;
        int n = board[0].length;
        if(i-1 >= 0 && board[i-1][j] == 'O') dfs(board, i-1, j);
        if(i+1 < m && board[i+1][j] == 'O') dfs(board, i+1, j);
        if(j-1 >= 0 && board[i][j-1] == 'O') dfs(board, i, j-1);
        if(j+1 < n && board[i][j+1] == 'O') dfs(board, i, j+1);
    }
}

//bfs time limit
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') bfs(board, i, 0);
            if(board[i][n-1] == 'O') bfs(board, i, n-1);
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') bfs(board, 0, j);
            if(board[m-1][j] == 'O') bfs(board, m-1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '+') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    public void bfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        Queue<Integer[]> q = new LinkedList<Integer[]>();
        q.add(new Integer[]{i, j});
        while(!q.isEmpty()) {
            Integer[] temp = q.remove();
            int x = temp[0];
            int y = temp[1];
            board[x][y] = '+';
            if(x-1 >= 0 && board[x-1][y] == 'O') q.add(new Integer[]{x-1, y});
            if(x+1 < m && board[x+1][y] == 'O') q.add(new Integer[]{x+1, y});
            if(y-1 >= 0 && board[x][y-1] == 'O') q.add(new Integer[]{x, y-1});
            if(y+1 < n && board[x][y+1] == 'O') q.add(new Integer[]{x, y+1});
        }
    }
}