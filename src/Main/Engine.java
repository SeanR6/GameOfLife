package Main;
//runs the game, starts everything from being called from main
public class Engine {
     public Engine(){
        //Each loop go through if statements so that each cell will die or live or be created for
        // every value on the game board, probably should put if statements in UI, consider creating
        // game board class.
         GameBoard board = new GameBoard();
         UI ui = new UI();
         //for testing run 10 times, implement a way to allow user to either advance or
         //run for x number of iterations
         for(int i = 0; i < 10; i++){
             //game loop: implement a function in gameboard that iterates through and finds each cell
             // and operates on it

             //stuff here

             //print
             ui.printUI(board);
         }
    }
}

