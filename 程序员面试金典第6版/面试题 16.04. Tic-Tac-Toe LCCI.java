 class Solution {
    public String tictactoe(String[] board) {
        int n = board.length;
        int rowSum = 0, colSum = 0, diag1Sum = 0, diag2Sum = 0;
        boolean flag = false;

        for(int i=0; i<n; i++) {
            rowSum = 0;
            colSum = 0;
            for(int j=0; j<n; j++) {
                rowSum += board[i].charAt(j);
                colSum += board[j].charAt(i);
                if(!flag && board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }
            if(rowSum == 'X'*n) return "X";
            if(rowSum == 'O'*n) return "O";
            if(colSum == 'X'*n) return "X";
            if(colSum == 'O'*n) return "O";
            diag1Sum += board[i].charAt(i);
            diag2Sum += board[i].charAt(n-i-1);
        }
        if(diag1Sum == 'X'*n) return "X";
        if(diag1Sum == 'O'*n) return "O";
        if(diag2Sum == 'X'*n) return "X";
        if(diag2Sum == 'O'*n) return "O";

        if(flag) {
            return "Pending";
        } else {
            return "Draw";
        }
    }
}