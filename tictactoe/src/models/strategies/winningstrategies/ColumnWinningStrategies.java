package models.strategies.winningstrategies;

import models.Board;
import models.Move;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ColumnWinningStrategies implements WinningStrategies {

    Map<Integer,Map<String,Integer>> colCount = new HashMap<>();
    @Override
    public boolean isWinningMove(Board board, Move move) {
        int col = move.getCell().getCol();
        String symbol = move.getCell().getPlayer().getSymbol().getSymbol();
        if(!colCount.containsKey(col)){
            colCount.put(col,new HashMap<>());
        }

        Map<String,Integer> colMap = colCount.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }

        colMap.put(symbol,colMap.get(symbol)+1);

        if(colMap.get(symbol).equals(board.getDimension())){
            return true;
        }

        return false;
    }
}
