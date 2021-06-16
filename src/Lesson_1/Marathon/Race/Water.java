package Lesson_1.Marathon.Race;

import Lesson_1.Marathon.Runners.Competitor;

public class Water extends Obstacle {
    private int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    protected void doIt(Competitor competitor) {
        competitor.swim(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
