package models.strategies.botmovingstrategies;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

import java.util.List;

public class EasyBotMovingStrategy implements BotMovingStrategies{
    @Override
    public Move moveBot(Board board) {
        List<List<Cell>> squareBoard = board.getBoard();
        for(int i=0;i<squareBoard.size();i++){
            for(int j=0;j<squareBoard.get(i).size();j++){
                if(squareBoard.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                        System.out.println("Bot made to row "+i+" col "+j);
                        return new Move(new Cell(i,j),null);
                }
            }
        }
        return null;
    }
}
