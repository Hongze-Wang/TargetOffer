// C++ 可以这么写 因为C/C++ 里面 非0数字都表示true 仅有0表示false
class Solution {
public:
    string tictactoe(vector<string>& board) {
        int n = board.size();
        bool full = true;
        bool diag1XWin = false, diag1OWin = false;
        bool diag2XWin = false, diag2OWin = false;

        for(int i=0; i<n; i++) {
            bool rowXWin = false, rowOWin = false;
            bool colXWin = false, colOWin = false;
            for(int j=0; j<n; j++) {
                if(full && board[i][j] == ' ') {
                    full = false;
                }
                if(!rowXWin) rowXWin = rowXWin || ('X' ^ board[i][j]);
                if(!rowOWin) rowOWin = rowOWin || ('O' ^ board[i][j]);
                if(!colXWin) colXWin = colXWin || ('X' ^ board[j][i]);
                if(!colOWin) colOWin = colOWin || ('O' ^ board[j][i]);
            }

            if(rowXWin == false || colXWin == false) return "X";
            if(!rowOWin || !colOWin) return "O";
            // diagnonal
            diag1XWin = diag1XWin || ('X' ^ board[i][i]);
            diag1OWin = diag1OWin || ('O' ^ board[i][i]);
            diag2XWin = diag2XWin || ('X' ^ board[i][n-i-1]);
            diag2OWin = diag2OWin || ('O' ^ board[i][n-i-1]);
        }

        if(!diag1XWin || !diag2XWin) return "X";
        if(!diag1OWin || !diag2OWin) return "O";

        if(full) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
};