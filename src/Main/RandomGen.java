package Main;


public class RandomGen {
    private long seed;
    private static final int K = 16807;
    private static final int J = 2147483647;
    private double output;

    //constructor
    public void RandomGen(){
        seed = System.currentTimeMillis();
    }


    //Function to generate random number between 0 and 1,
    // multiply by func input x to get seed between 0 and that number
    public int generate(int x){
        seed = (K*seed)%J;
        output = (double)seed/(double)J;
        return (int)Math.round(output);
    }


}