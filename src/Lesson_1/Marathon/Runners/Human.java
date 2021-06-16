package Lesson_1.Marathon.Runners;


public class Human extends Being implements Competitor {

    public Human(String name) {
        this.type = "Человек";
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 30;
        this.maxSwimDistance = 200;
        this.active = true;
    }

}