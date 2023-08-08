package com.springboot.demo.springdev.rest;

import com.springboot.demo.springdev.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Define private field for the dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }

    // define a setter for dependency injection
//    @Autowired
//    private void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
