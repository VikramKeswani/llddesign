package models.strategies.winningstrategies;

import models.Board;
import models.Cell;
import models.Move;

import java.util.List;

public interface WinningStrategies {

    public boolean isWinningMove(Board board, Move move);

}
