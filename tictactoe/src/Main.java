import controller.GameController;
import models.*;
import models.strategies.winningstrategies.ColumnWinningStrategies;
import models.strategies.winningstrategies.DiagonalWinningStrategies;
import models.strategies.winningstrategies.RowWinningStrategies;
import models.strategies.winningstrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        players.add(new Player("vikram", new Symbol("X")));
        players.add(new Bot("bot", new Symbol("O"), DifficultyLevel.EASY));
        int boardSize = 3;

        List<WinningStrategies> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategies());
        winningStrategies.add(new ColumnWinningStrategies());
        winningStrategies.add(new DiagonalWinningStrategies());

        Game game = gameController.startGame(boardSize, players, winningStrategies);

        System.out.println(game.toString());


        while (gameController.checkGameState(game).equals(GameState.IN_PROGRESS)) {
            // print board
            gameController.printBoard(game);
            System.out.print("\n");
            //make move
            gameController.makeMove(game);
        }

        if(gameController.checkGameState(game).equals(GameState.DRAW)){
            System.out.println("Game is Draw");
        }

        System.out.println("Winner is:"+gameController.getWinner(game).getName());

    }
}