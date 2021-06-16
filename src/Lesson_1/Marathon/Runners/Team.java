package Lesson_1.Marathon.Runners;

import Lesson_1.Marathon.Race.Obstacle;

public class Team {
    public final Being[] runners = new Being[4];

    public Team(String humanName, String catName, String dogName, String monkeyName) {
        this.runners [0] = new Human(humanName);
        this.runners [1] = new Cat(catName);
        this.runners [2] = new Dog(dogName);
        this.runners [3] = new Monkey(monkeyName);
    }

    public void showResults() {
        if (runners[0].active) {
            System.out.println(runners[0].getType() + " " + runners [0].getName() + " прошёл полосу препятствий.");
        } else if (runners[1].active) {
            System.out.println(runners[1].getType() + " " + runners[1].getName() + " прошёл полосу препятствий.");
        } else if (runners[2].active) {
            System.out.println(runners[2].getType() + " " + runners[2].getName() + " прошёл полосу препятствий.");
        } else if (runners[3].active) {
            System.out.println(runners[3].getType() + " " + runners[3].getName() + " прошёл полосу препятствий.");
        } else {
            System.out.println("Никто не преодолел полосу препятствий.");
        }
    }

    public void teamInfo() {
        System.out.println("Состав участников:");
        System.out.println(runners[0].getType() + " " + runners [0].getName());
        System.out.println(runners[1].getType() + " " + runners [1].getName());
        System.out.println(runners[2].getType() + " " + runners [2].getName());
        System.out.println(runners[3].getType() + " " + runners [3].getName());

    }

    public Being[] getRunners() {
        return runners;
    }
}
