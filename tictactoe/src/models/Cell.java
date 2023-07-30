package models;

public class Cell {
    CellState cellState;
    int row;
    int col;
    Player player;

    public Cell(int row, int col) {
        this.cellState = CellState.EMPTY;
        this.row = row;
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void display() {
        if (player == null) {
            System.out.print("| - |");
        } else {
            System.out.printf("| " + player.getSymbol().getSymbol() + " |");
        }
    }
}
