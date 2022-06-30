package flowService;

import flowModels.Ladder;
import flowModels.Player;
import flowModels.Snake;
import flowModels.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {

    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialNumberOfPlayers;
    private Queue<Player> players;          // keeping players in queue to play in turns
    private boolean isGameCompleted;

    private int noOfDices;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleRollOnSix;

    private static final int defaultBoardSize = 100;
    private static final int defaultNoOfDices = 1;

    public SnakeAndLadderService(int boardSize){
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<>();
        this.noOfDices = SnakeAndLadderService.defaultNoOfDices;
    }

    public SnakeAndLadderService(){
        this(SnakeAndLadderService.defaultBoardSize);
    }

    //setter methods

    public void setNoOfDices(int noOfDices){
        this.noOfDices = noOfDices;
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer){
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void isShouldAllowMultipleRollOnSix(boolean shouldAllowMultipleRollOnSix){
        this.shouldAllowMultipleRollOnSix = shouldAllowMultipleRollOnSix;
    }


    // let initialize the board

    public void setPlayers(List<Player> players){
        this.players = new LinkedList<>();
        this.initialNumberOfPlayers = players.size();
        Map<String,Integer>playerPieces = new HashMap<>();
        for(Player player:players){
            this.players.add(player);
            playerPieces.put(player.getId(),0);
        }
        snakeAndLadderBoard.setPlayerPieces(playerPieces);
    }

    //add snakes to board
    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes);
    }

    //add ladders to board
    public void setLadders(List<Ladder> ladders){
        snakeAndLadderBoard.setLadders(ladders);
    }

    private int getNewPositionAfterSnakesAndLadders(int newPosition){

         int previousPosition;
        do{
            previousPosition = newPosition;
            for(Snake snake:snakeAndLadderBoard.getSnakes()){
                if(snake.getStart()==newPosition){        //whenever players meets snake ,they will end up at snake end
                    newPosition = snake.getEnd();
                }
            }

            for(Ladder ladder:snakeAndLadderBoard.getLadders()){
                if(ladder.getStart()==newPosition){       // whenever players meet ladder , they will end up at ladder end
                    newPosition = ladder.getEnd();
                }
            }
        }
        while (newPosition != previousPosition);         //there could be no snake/ladder at snake/ladder end point so piece move up/down
        return newPosition;
    }

    private void movePlayer(Player player,int positions){
        int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition+positions;    //based on dice number player move accordingly

        int boardSize = snakeAndLadderBoard.getSize();


        // special case where dice is thrown out of board size ,player piece shouldn't move
        if(newPosition >boardSize){
            newPosition = oldPosition;
        }

        else{
            newPosition = getNewPositionAfterSnakesAndLadders(newPosition);
        }

        snakeAndLadderBoard.getPlayerPieces().put(player.getId(),newPosition);

        System.out.println(player.getName() + " rolled a " +positions+ " and moved from " +oldPosition+ " to " +newPosition);
    }

    private int getTotalValueAfterDiceRolls(){
        //should allow multiple rolls on getting six on dice
        return DiceService.roll();
    }

    public boolean hasPlayerWon(Player player){
        int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int winningPosition = snakeAndLadderBoard.getSize();

        return playerPosition == winningPosition;
    }

    public boolean isGameCompleted() {

        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers<initialNumberOfPlayers;
    }

    public void startGame(){
        while(!isGameCompleted()){
            int totalDiceValue = getTotalValueAfterDiceRolls();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer,totalDiceValue);
            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getName()  + "wins the game ");
                snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
            }
            else {
                players.add(currentPlayer);
            }
        }

    }
}
