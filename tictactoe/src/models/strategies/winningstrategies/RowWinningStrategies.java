package models.strategies.winningstrategies;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategies implements WinningStrategies {

    Map<Integer, Map<String,Integer>> rowCount = new HashMap<>();
    @Override
    public boolean isWinningMove(Board board, Move moves) {
        int row = moves.getCell().getRow();
        String symbol = moves.getCell().getPlayer().getSymbol().getSymbol();
        if(!rowCount.containsKey(row)){
            rowCount.put(row,new HashMap<>());
        }

        Map<String,Integer> rowMap = rowCount.get(row);

        if (!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }

        rowMap.put(symbol,rowMap.get(symbol)+1);

        System.out.println("rached here");

        if(rowMap.get(symbol).equals(board.getDimension())){
            return true;
        }

        return false;
    }
}
