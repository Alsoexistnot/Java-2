package Lesson_1.Marathon.Race;

import Lesson_1.Marathon.Runners.Competitor;

public class Cross extends Obstacle {
    private int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    protected void doIt(Competitor competitor) {
        competitor.run(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
