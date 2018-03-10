package Main;

public class UI {
    private int[][] UI;
    private int x;
    private int y;
    RandomGen random;

    //default constructor if size isn't specified
    //UI also contains the game board and should be treated as such
    void UI(){
        UI = new int[20][20];
        x = 20;
        y = 20;
        random = new RandomGen();
    }
    //constructor if game field size is to be customized
    void UI(int x, int y){
        UI = new int[x][y];

        //TODO generate values to be starting seeds


    }

    //prints the game field, to be printed after every turn to
    void printUI(){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(UI[x][y] == 1){
                    System.out.print("0");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
