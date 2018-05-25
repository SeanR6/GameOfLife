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
    //0,0 should be bottom left
    //still shouldnt change math cause + is just right and down
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
        //iterate and apply checks for every cel
        //TODO change function names
        for(int i = 0; i < x;){
            for( int j = 0; j < y; j++){
                int surroundingCells=0;
                if(i == 0 && j == 0){
                    //encapsulate these if statements into a separate method, checkSurrounding?
                    //maybe implement it only for the inside squares?
                    if(checkUp(i,j))
                        ++surroundingCells;
                    if (checkUpRight(i,j))
                        ++surroundingCells;
                    if (checkRight(i,j))
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
                    if(checkLeft(i,j))
                        ++surroundingCells;
                    if (checkRight(i,j))
                        ++surroundingCells;
                    if (checkUpLeft(i,j))
                        ++surroundingCells;
                    if(checkUpRight(i,j))
                        ++surroundingCells;
                    if(checkUp(i,j))
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
                }else if(j == 0) {
                    if (checkUp(i,j))
                        ++surroundingCells;
                    if (checkDown(i,j))
                        ++surroundingCells;
                    if (checkRight(i,j))
                        ++surroundingCells;
                    if (checkUpRight(i,j))
                        ++surroundingCells;
                    if (checkDownRight(i,j))
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
                //TODO CHANGE THE FOLLOWING TO MATCH FOR X,Y == MAX
                //TODO MIGHT BE ERROR EXCEEDING BOUNDS i.e THE CORNERS OF THE BOARD
                if(i == x-1 && j == y-1){
                    //encapsulate these if statements into a separate method, checkSurrounding?
                    //maybe implement it only for the inside squares?
                    if( checkDown(i,j))
                        ++surroundingCells;
                    if (checkLeft(i,j))
                        ++surroundingCells;
                    if (checkDownLeft(i,j))
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
                    //DONE UP TO HERE ------------------------------------
                } else if(i == x-1){
                    if( checkLeft(i,j))
                        ++surroundingCells;
                    if (checkDown(i,j))
                        ++surroundingCells;
                    if (checkRight(i,j))
                        ++surroundingCells;
                    if(checkDownLeft(i,j))
                        ++surroundingCells;
                    if(checkDownRight(i,j))
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
                }else if(j == y-1) {
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
                //these are the ones for the middle of the board
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


    private boolean checkLeft(int i, int j){
        if(board[-i][j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkRight(int i, int j){
        if(board[+i][j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkUp(int i, int j){
        if(board[i][+j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkDown(int i, int j){
        if(board[i][-j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkUpLeft(int i, int j){
        if(board[-i][+j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkUpRight(int i, int j){
        if(board[+i][+j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkDownLeft(int i, int j){
        if(board[-i][-j] == 1){
            return true;
        }else{
            return false;
        }
    };
    private boolean checkDownRight(int i, int j){
        if(board[+i][-j] == 1){
            return true;
        }else{
            return false;
        }
    };
}
