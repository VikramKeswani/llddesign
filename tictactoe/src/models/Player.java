package models;

import java.util.Scanner;

public class Player {
    String name;
     Symbol symbol;
     PlayerType playerType;

     Scanner scanner;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.playerType=PlayerType.HUMAN;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board){
        System.out.println(name+" enter row number");
        int row = scanner.nextInt();
        System.out.println(name+" enter col number:");
        int col=scanner.nextInt();
//        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)){
//                System.out.println("Invalid move cell is already occupied");
//                return null;
//        }
        return new Move(new Cell(row,col),this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
