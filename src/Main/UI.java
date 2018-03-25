package Main;

public class UI {
    //wtf even is this? look over later? maybe just for test case
    //public UI(GameBoard input){
    //    GameBoard board = input;
    //}

    //prints the game field, to be printed after every turn to
    static void printUI(GameBoard board){
        for(int i = 0; i < board.getY(); i++){
            for(int j = 0; j < board.getX(); j++){
                if(board.valueAt(j,i) == 1){
                    System.out.print("0");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
