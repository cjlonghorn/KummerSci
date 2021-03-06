public class Player {
    private int score;
    private String name;
    // private data
    public Player() {
        //default constructor
        //blank private data
        setScore(0);
        setName("");
    }
    public Player(int inScore, String inName) {
        //fill constructor
        //set private data to inputs
        setScore(inScore);
        setName(inName);
    }

    //Sets and Gets
    public void setName(String inName) {
    	name = inName;
    }
    public String getName() {
    	return name;
    }
    public void setScore(int inScore) {
    	score = inScore;
    }
    public int getScore() {
    	return score;
    }

    //other Methods
    //return a boolean to check if input is bigger than the private score
    public boolean checkScore(int inOther) {
        if(score < inOther) {
            return true;
        } else {
            return false;
        }
    }
    //Send output as a string
    public String toString() {
        return name + "\n" + score + "\n";
        //possible issue could be an extra new line, check if not working*****
    }
}