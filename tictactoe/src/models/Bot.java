package models;

import models.strategies.botmovingstrategies.BotMovingStrategies;
import models.strategies.botmovingstrategies.BotMovingStrategyFactory;

public class Bot extends Player{
    DifficultyLevel difficultyLevel;

    BotMovingStrategies botMovingStrategies;

    public Bot(String name, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(name, symbol);
        this.playerType=PlayerType.BOT;
        this.difficultyLevel=difficultyLevel;
        this.botMovingStrategies= BotMovingStrategyFactory.getBotMovingStategyObject(difficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
           return botMovingStrategies.moveBot(board);
    }
}
