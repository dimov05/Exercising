package com.springboot.demo.springdev.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;
@Value("${team.name}")
   private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World :)!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 10k!";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day :)";
    }

    // Expose new endpoint for 'teaminfo'
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return String.format("The coach is: %s, and the team is: %s", coachName, teamName);
    }

}
