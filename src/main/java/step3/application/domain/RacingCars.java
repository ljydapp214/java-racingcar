package step3.application.domain;

import step3.application.domain.model.MovementLog;
import step3.application.domain.model.OneMoveRecord;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;
    private final MovableGenerator movableGenerator;

    public RacingCars(List<Car> cars, MovableGenerator movableGenerator) {
        this.cars = cars;
        this.movableGenerator = movableGenerator;
    }

    public OneMoveRecord moveCars() {
        List<MovementLog> oneMoveResult = this.cars.stream()
                .map(car -> car.move(canMove()))
                .collect(Collectors.toList());
        return new OneMoveRecord(oneMoveResult);
    }

    private boolean canMove() {
        return movableGenerator.drawMovable();
    }
}