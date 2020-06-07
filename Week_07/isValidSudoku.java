class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null)
            return false;
        if(board.length !=9)
            return false;
        int[] map = new int[9];
        for(int y=0; y<9; y++){
            if(board[y] == null || board[y].length != 9)
                return false;
            for(int x=0; x<9; x++){
                int key = board[y][x] - '1';
                if(key >= 0 && key <= 8) {
                    int index = (1<<x)
                            | (1<<(y+9))
                            | (1<<(x/3 + y/3*3 + 18));
                    int old = map[key];
                    if((old & index) == 0)
                        map[key] = old | index;
                    else    //有重复
                        return false;
                }
            }
        }
        return true;
    }
}