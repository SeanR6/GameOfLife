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
}
