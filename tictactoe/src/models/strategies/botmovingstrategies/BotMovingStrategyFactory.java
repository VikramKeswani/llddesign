package models.strategies.botmovingstrategies;

import models.DifficultyLevel;

public class BotMovingStrategyFactory {

    public static BotMovingStrategies getBotMovingStategyObject(DifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(DifficultyLevel.EASY)){
            return new EasyBotMovingStrategy();
        }

        else if(difficultyLevel.equals(DifficultyLevel.MEDIUM)){
            return new MediumBotMovingStrategy();
        }

        return null;
    }
}
