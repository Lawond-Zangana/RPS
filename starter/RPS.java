/* 
 Name: Lawond Zangana 
 Email: lazangana@ucsd.edu
 PID: A17708568
 Sources Used: Tutor help
 */

import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     *
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            System.arraycopy(args, 0, moves, 0, args.length);
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
        
        System.out.println(PROMPT_MOVE);
        String input = in.nextLine();
        while (input.equals("q") == false) {

            String cpuMoves = game.genCPUMove();
            boolean b1 = game.isValidMove(input);
            if (b1 == false) {
                System.out.println(INVALID_INPUT);
            } else {
            game.determineWinner(input, cpuMoves);
            game.playRPS(input, cpuMoves);
            }
            System.out.println(PROMPT_MOVE);
            input = in.nextLine();
        
        }
        game.displayStats(); 
        
        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work! And don't forget Javadoc.

        in.close();
    }

    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        // Initialize variables
        int playerMove1 = -1;
        int cpuMove1 = -1;
        if (!isValidMove(playerMove) || !isValidMove(cpuMove)) {
            return INVALID_INPUT_OUTCOME;
        }
       /* first for loop that finds out what the player chose based on 
       index location in possibleMoves array. */
       for (int i = 0; i < possibleMoves.length; i++) { 
        // System.out.println(possibleMoves[i] + " " + playerMove);
        if(playerMove.equals(possibleMoves[i])) {
             playerMove1 = i; 
          } 
        } 
        /*  second for loop that finds out what the CPU chose based on 
       index location in possibleMoves array. */
        for (int j = 0; j < possibleMoves.length; j++) {
            if(cpuMove.equals(possibleMoves[j])) { 
              cpuMove1 = j; 
            }
        }
        /* Series of if statements for each possible scenario. */
         if ((playerMove1 == 0) && (cpuMove1 == possibleMoves.length-1)) {
            return PLAYER_WIN_OUTCOME; 
        } else 
        if ((cpuMove1 == 0) && (playerMove1 == possibleMoves.length-1)) {
            return CPU_WIN_OUTCOME;
        } else 
        if (playerMove1 == cpuMove1 + 1) { 
            return PLAYER_WIN_OUTCOME; 
        } else
        if (cpuMove1 == playerMove1 + 1) { 
            return CPU_WIN_OUTCOME; 
        } else 
            return TIE_OUTCOME; 
        
    } 
} 

