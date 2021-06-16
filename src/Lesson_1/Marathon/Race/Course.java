package Lesson_1.Marathon.Race;

import Lesson_1.Marathon.Runners.Being;
import Lesson_1.Marathon.Runners.Team;


public class Course {
    private final Obstacle[] obstacles = new Obstacle[3];

    public Course(int wallHeight, int waterLength, int crossLength) {
        obstacles[0] = new Cross(crossLength);
        obstacles[1] = new Water(waterLength);
        obstacles[2] = new Wall(wallHeight);
    }

    public void raceBegins(Team team, Course course) {
        for (int i = 0; i < team.runners.length; i++) {
            for (int j = 0; j < course.obstacles.length; j++) {
                course.obstacles[j].doIt(team.runners[i]);
            }
        }
    }
}
