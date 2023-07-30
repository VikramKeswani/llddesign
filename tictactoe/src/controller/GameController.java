package controller;

import models.Game;
import models.GameState;
import models.Player;
import models.strategies.winningstrategies.WinningStrategies;

import java.util.List;

public class GameController {


    public Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies){
        return Game.builder().setPlayers(players).setBoardSize(dimension).setWinningStrategies(winningStrategies).build();
    }

    public GameState checkGameState(Game game){
        return game.checkState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

}
