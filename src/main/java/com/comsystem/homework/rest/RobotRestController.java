package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import com.comsystem.homework.robot.RobotOperations;

import java.net.URI;

@RestController()
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")

    //TODO: С по-малък брой дни (до 40) програмата работи коректно :)
    // Ако подам 41-42 или повече дни, Postman крашва поради големия брой "DIG, CLONE, DIG" в листа RobotAction.
    // Ако подам 100 дни програмата се чупи с Java Heap Space грешка.

    public ResponseEntity<RobotPlan> excavateStones(@RequestParam(name = "days") Integer numberOfDays) {

        RobotPlan robotPlan =
                new RobotOperations()
                        .excavateStonesForDays(numberOfDays);

        //TODO: В интернет пише че "I_AM_A_TEAPOT" или 418 ерор е някаква ебавка(April Fools' jokes in 1998 and 2014).
        // Аз реших да я троуна, ако подам отрицателен брой дни.

        if (numberOfDays < 0) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }

        return ResponseEntity
                .created(URI.create(String.format("/api/v1/robot/operation/excavation?days=%d", numberOfDays)))
                .body(robotPlan);
    }


    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    //TODO: Програмата работи коректно с доста големи числа :)
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam(name = "stones") Integer numberOfStones) {

        RobotPlan robotPlan =
                new RobotOperations()
                        .daysRequiredToCollectStones(numberOfStones);

        if (numberOfStones < 0) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }

        return ResponseEntity
                .created(URI.create(String.format("/api/v1/robot/operation/approximation?stones=%d", numberOfStones)))
                .body(robotPlan);

    }

    //TODO: Мой GET CONTROLLER (не е по заданието). Може да се провери бизнес логиката с него.
    @GetMapping("/excavation/{numberOfDays}")
    public ResponseEntity<RobotPlan> getExcavateStones(@PathVariable("numberOfDays") Integer numberOfDays) {

        RobotPlan robotPlan =
                new RobotOperations()
                        .excavateStonesForDays(numberOfDays);

        return ResponseEntity
                .ok(robotPlan);

    }

    //TODO: Мой GET CONTROLLER (не е по заданието). Може да се провери бизнес логиката с него.
    @GetMapping("/approximation/{numberOfStones}")
    public ResponseEntity<RobotPlan> getApproximateDays(@PathVariable("numberOfStones") Integer numberOfStones) {

        RobotPlan robotPlan =
                new RobotOperations()
                        .daysRequiredToCollectStones(numberOfStones);

        return ResponseEntity
                .ok(robotPlan);

    }
}
