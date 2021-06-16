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
    }
}
