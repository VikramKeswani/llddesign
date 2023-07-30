package models;

import models.strategies.winningstrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;


public class Game {

    int boardSize;
    List<WinningStrategies> winningStrategies;

    List<Player> players;

    List<Move> moves;

    GameState gameState;
    Board board;

    Player winner;
    int currentPlayerChance;


    public Game(int boardSize, List<Player> players, List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
        this.boardSize=boardSize;
        this.players=players;
        gameState = GameState.IN_PROGRESS;
        this.board = new Board(boardSize);
        currentPlayerChance=0;
        this.moves = new ArrayList<>();
    }

    public static Builder builder(){
        return new Builder();
    }

    public GameState checkState(){
        return gameState;
    }

    public void printBoard(){
        board.printBoard();
    }

    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerChance);

        Move move = currentPlayer.makeMove(board);


        if(!validateMove(move)){
            System.out.println("Invalid Move Please try again");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);
        Move finalMoveObject = new Move(cell, currentPlayer);
        moves.add(finalMoveObject);
        if(checkWinner(board,finalMoveObject)){
            gameState=GameState.WINNNER;
            winner = currentPlayer;
            return;
        }

        else if(moves.size()== (board.dimension*board.dimension)){
            gameState=GameState.DRAW;
            return;
        }

        currentPlayerChance+=1;
        currentPlayerChance%=players.size();
    }


    public static class Builder{
        int boardSize;
        List<Player> players;

        List<WinningStrategies> winningStrategies;



        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;

        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            return new Game(boardSize,players,winningStrategies);
        }
    }

    private boolean checkWinner(Board board, Move move) {
        for(WinningStrategies obj:winningStrategies){
            boolean isWinner = obj.isWinningMove(board,move);
            if(isWinner){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game{" +
                "boardSize=" + boardSize +
                ", winningStrategies=" + winningStrategies +
                ", players=" + players +
                ", moves=" + moves +
                ", gameState=" + gameState +
                ", board=" + board +
                ", currentPlayerChance=" + currentPlayerChance +
                '}';
    }

    private boolean validateMove(Move move){
        if(move.getCell().getRow()>=board.dimension){
            return false;
        }

        if(move.getCell().getCol()>=board.dimension){
            return false;
        }

        if(board.getBoard().get(move.getCell().getRow()).get(move.getCell().getCol()).getCellState().equals(CellState.FILLED))
                    return false;

        return true;
    }

    public Player getWinner(){
            return winner;
    }
}
