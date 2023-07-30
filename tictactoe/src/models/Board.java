package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board;

    int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }


    void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                cell.display();
            }
            System.out.print("\n");
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
