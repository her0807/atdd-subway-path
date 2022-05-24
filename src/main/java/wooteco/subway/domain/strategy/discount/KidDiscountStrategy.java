package wooteco.subway.domain.strategy.discount;

public class KidDiscountStrategy implements DiscountStrategy {

    protected static final int DEDUCTION = 350;

    @Override
    public int calculate(int fare) {
        int targetFare = fare - DEDUCTION;
        return targetFare - (int) (targetFare * 0.5);
    }
}
