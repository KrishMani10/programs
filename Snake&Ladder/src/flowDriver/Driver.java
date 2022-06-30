package flowDriver;

import flowModels.Ladder;
import flowModels.Player;
import flowModels.Snake;
import flowService.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("No of snakes : ");
        int noOfSnakes = s.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i=0;i<noOfSnakes;i++){
            snakes.add(new Snake(s.nextInt(),s.nextInt()));
        }

        System.out.println("No of Ladders :");
        int noOfLadders = s.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int j=0;j<noOfLadders;j++){
            ladders.add(new Ladder(s.nextInt(),s.nextInt()));
        }

        System.out.println("No of Players : ");
        int noOfPlayers = s.nextInt();
        List<Player> players = new ArrayList<>();
        for(int k=0;k<noOfPlayers;k++){
            players.add(new Player(s.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);
            snakeAndLadderService.startGame();

    }
}
