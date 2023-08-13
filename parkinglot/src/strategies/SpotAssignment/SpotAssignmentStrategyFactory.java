package strategies.SpotAssignment;

import models.enums.SpotFindingStrategyType;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentType spotAssignmentStrategy(SpotFindingStrategyType spotFindingStrategyType){
        if(spotFindingStrategyType.equals(SpotFindingStrategyType.RANDOM))
                return new RandomSpotAssignmentStrategy();

        else if(spotFindingStrategyType.equals(SpotFindingStrategyType.SEQUENTIAL))
            return new SequentialSpotAssignmentStrategy();


        return null;
    }
}
