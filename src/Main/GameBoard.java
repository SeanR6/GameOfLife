package Main;

public class GameBoard {
    private int[][] board;
    private int x;
    private int y;
    RandomGen random;
    //constructor

    public GameBoard(){
        x = 40;
        y = 40;
        board = new int[x][y];
        random = new RandomGen(x);

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int valueAt(int x, int y){
        return board[x][y];
    }

    public void takeTurn(){
        //iterate and apply checks for every cell
        for(int i = 0; i < x;){
            for( int j = 0; j < y; j++){
                int surroundingCells=0;
                if(i == 0 && j == 0){
                    //encapsulate these if statements into a separate method, checkSurrounding?
                    //maybe implement it only for the inside squares?
                    if( check(i+1, j) ==1)
                        ++surroundingCells;
                    if (check(i+1, j+1) ==1)
                        ++surroundingCells;
                    if (check(i, j+1)==1)
                        ++surroundingCells;
                    if(surroundingCells < 2){
                        board[i][j] = 0;
                    }else if(surroundingCells > 3){
                        board[i][j] = 0;
                    }else if(board[i][j] == 1 &&(surroundingCells == 3 || surroundingCells ==2) ){
                        board[i][j] = 1;
                    }else if( board[i][j] == 0 &&(surroundingCells == 2)){
                        board[i][j] = 1;
                    }
                } else if(i == 0){
                    if( check(i+1, j) ==1)
                        ++surroundingCells;
                    if (check(i+1, j+1) ==1)
                        ++surroundingCells;
                    if (check(i, j+1)==1)
                        ++surroundingCells;
                    if(check(i+1, j-1) == 1)
                        ++surroundingCells;
                    if(check(i, j-1) ==1)
                        surroundingCells++;
                    if(surroundingCells < 2){
                        board[i][j] = 0;
                    }else if(surroundingCells > 3){
                        board[i][j] = 0;
                    }else if(board[i][j] == 1 &&(surroundingCells == 3 || surroundingCells ==2) ){
                        board[i][j] = 1;
                    }else if( board[i][j] == 0 &&(surroundingCells == 2)){
                        board[i][j] = 1;
                    }
                }else if(i == 0) {
                    if (check(i + 1, j) == 1)
                        ++surroundingCells;
                    if (check(i + 1, j + 1) == 1)
                        ++surroundingCells;
                    if (check(i, j + 1) == 1)
                        ++surroundingCells;
                    if (check(i - 1, j) == 1)
                        ++surroundingCells;
                    if (check(i - 1, j + 1) == 1)
                        surroundingCells++;
                    if (surroundingCells < 2) {
                        board[i][j] = 0;
                    } else if (surroundingCells > 3) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 1 && (surroundingCells == 3 || surroundingCells == 2)) {
                        board[i][j] = 1;
                    } else if (board[i][j] == 0 && (surroundingCells == 2)) {
                        board[i][j] = 1;
                    }
                }
                //Do the ones for i, j == max
                //this is the ones for the middle of the board
                else{
                    if (check(i + 1, j) == 1)
                        ++surroundingCells;
                    if (check(i + 1, j + 1) == 1)
                        ++surroundingCells;
                    if (check(i+1, j - 1) == 1)
                        ++surroundingCells;
                    if (check(i, j+1) == 1)
                        ++surroundingCells;
                    if (check(i, j - 1) == 1)
                        ++surroundingCells;
                    if (check(i - 1, j+1) == 1)
                        ++surroundingCells;
                    if (check(i - 1, j) == 1)
                        ++surroundingCells;
                    if (check( i-1, j - 1) == 1)
                        ++surroundingCells;

                    if (surroundingCells < 2) {
                        board[i][j] = 0;
                    } else if (surroundingCells > 3) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 1 && (surroundingCells == 3 || surroundingCells == 2)) {
                        board[i][j] = 1;
                    } else if (board[i][j] == 0 && (surroundingCells == 2)) {
                        board[i][j] = 1;
                    }

                }
            }
        }

    }

    private int check(int i, int j){
        if(board[i][j] == 1){
            return 1;
        }else{
            return 0;
        }
    }
}
