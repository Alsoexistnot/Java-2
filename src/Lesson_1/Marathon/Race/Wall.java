package Lesson_1.Marathon.Race;

import Lesson_1.Marathon.Runners.Competitor;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    protected void doIt(Competitor competitor) {
        competitor.jump(height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
