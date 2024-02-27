package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {
    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     * algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     * number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     * days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {

        int totalRobots = 1;
        int totalStones = 0;
        int totalDays = 0;

        RobotAction dig = RobotAction.DIG;
        RobotAction clone = RobotAction.CLONE;

        List<RobotAction> currentList = new ArrayList<>();

        while (totalDays < days) {

            if (totalDays % 2 == 0) {

                for (int j = 0; j < totalRobots; j++) {
                    currentList.add(dig);
                    totalStones += 1;
                }

            } else {

                for (int j = 0; j < totalRobots; j++) {
                    currentList.add(clone);
                }

                totalRobots *= 2;
            }

            totalDays += 1;
        }

        return new RobotPlan(totalDays, totalStones, currentList);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     * {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {

        int totalRobots = 1;
        int totalStones = 0;
        int totalDays = 0;

        RobotAction dig = RobotAction.DIG;
        RobotAction clone = RobotAction.CLONE;

        List<RobotAction> currentList = new ArrayList<>();

        while (totalStones < numberOfStones) {

            if (totalDays % 2 == 0) {

                for (int j = 0; j < totalRobots; j++) {
                    currentList.add(dig);
                    totalStones += 1;
                }

            } else {

                for (int j = 0; j < totalRobots; j++) {
                    currentList.add(clone);
                }

                totalRobots *= 2;
            }

            totalDays += 1;
        }

        return new RobotPlan(totalDays, totalStones, currentList);
    }
}
