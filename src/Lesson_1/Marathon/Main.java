package Lesson_1.Marathon;

import Lesson_1.Marathon.Race.Course;
import Lesson_1.Marathon.Runners.Team;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Песок", "Ливень", "Крюк", "Кувалда");
        Course course = new Course(10, 100,400);
        course.raceBegins(team,course);
        System.out.println();
        team.showResults();
        System.out.println();
        team.teamInfo();








//        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
//        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
//        for (Competitor c : competitors) {
//            for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//            }
//        }
//        for (Competitor c : competitors) {
//            c.info();
//        }
    }
}