package models.strategies.winningstrategies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalWinningStrategies implements WinningStrategies{

    Map<String,Integer> leftDiagonal = new HashMap<>();
    Map<String,Integer> rightDiagonal = new HashMap<>();
    @Override
    public boolean isWinningMove(Board board, Move move) {
        int row =move.getCell().getRow();
        int col = move.getCell().getCol();
        String symbol = move.getCell().getPlayer().getSymbol().getSymbol();
        if(row==col){
            if(!leftDiagonal.containsKey(symbol)){
                leftDiagonal.put(symbol,0);
            }

            leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
            if(leftDiagonal.get(symbol)==board.getDimension())
                    return true;
        }

        if((row+col)==board.getDimension()){
            if(!rightDiagonal.containsKey(symbol)){
                rightDiagonal.put(symbol,0);
            }
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
            if(rightDiagonal.get(symbol)==board.getDimension())
                    return true;
        }
        return false;
    }
}
