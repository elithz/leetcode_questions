package LeetCodeQuestions.Medium;

public class word_search_m {
    public static boolean visited[][];
    public static void main(String[] args){
        char[][] chars = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(chars, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word){
        if(board.length == 0 || word == "") return false;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if((board[i][j] == word.charAt(0)) && backtracking(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtracking(char[][] board, String word, int startH, int startV, int len){
        if (len == word.length()) {
            return true;
        }
        if((startH >= board.length) || (startH < 0) || (startV >= board[0].length) || (startV < 0) || (board[startH][startV] != word.charAt(len)) || (visited[startH][startV])){
            return false;
        }

        visited[startH][startV] = true;

        if(backtracking(board, word, startH - 1, startV, len + 1) ||
        backtracking(board, word, startH + 1, startV, len + 1) ||
        backtracking(board, word, startH, startV - 1, len + 1) ||
        backtracking(board, word, startH, startV + 1, len + 1)){
            return true;
        }

        visited[startH][startV] = false;
        return false;
    }
}
