package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class RobotOperationsTest {
    private final static Integer DAYS = 3;
    private final static Integer STONES = 3;
    private RobotOperations operationsToTest;

    @BeforeEach
    void setup() {
        operationsToTest = new RobotOperations();
    }

    @Test
    void testExcavateStonesForDaysMethod() {
        //TODO: По-голям тест. Версия 1.
        int testDays = 3;
        int testStones = 3;
        List<RobotAction> testRobotActionList = new ArrayList<>();

        testRobotActionList.add(RobotAction.DIG);
        testRobotActionList.add(RobotAction.CLONE);
        testRobotActionList.add(RobotAction.DIG);
        testRobotActionList.add(RobotAction.DIG);

        RobotPlan testRobotPlan = new RobotPlan(testDays, testStones, testRobotActionList);
        int testListSize = testRobotPlan.robotActions().size();

        Assertions.assertEquals(testDays, operationsToTest.excavateStonesForDays(DAYS).numberOfDays());
        Assertions.assertEquals(testStones, operationsToTest.excavateStonesForDays(DAYS).numberOfStones());
        Assertions.assertEquals(testListSize, operationsToTest.excavateStonesForDays(DAYS).robotActions().size());
        Assertions.assertEquals(testRobotPlan, operationsToTest.excavateStonesForDays(DAYS));
    }

    @Test
    void testDaysRequiredToCollectStonesMethod() {
        //TODO: По-голям тест. Версия 1.
        int testDays = 3;
        int testStones = 3;
        List<RobotAction> testRobotActionList = new ArrayList<>();

        testRobotActionList.add(RobotAction.DIG);
        testRobotActionList.add(RobotAction.CLONE);
        testRobotActionList.add(RobotAction.DIG);
        testRobotActionList.add(RobotAction.DIG);

        RobotPlan testRobotPlan = new RobotPlan(testDays, testStones, testRobotActionList);
        int testListSize = testRobotPlan.robotActions().size();

        Assertions.assertEquals(testDays, operationsToTest.daysRequiredToCollectStones(STONES).numberOfDays());
        Assertions.assertEquals(testStones, operationsToTest.daysRequiredToCollectStones(STONES).numberOfStones());
        Assertions.assertEquals(testListSize, operationsToTest.daysRequiredToCollectStones(STONES).robotActions().size());
        Assertions.assertEquals(testRobotPlan, operationsToTest.daysRequiredToCollectStones(STONES));
    }

    /*@Test
    void test2ExcavateStonesForDaysMethod() {
        //TODO: Версия 2.
        int days = 5;
        Assertions
                .assertEquals(
                        operationsToTest.excavateStonesForDays(days),
                        operationsToTest.excavateStonesForDays(5)
                );
    }

    @Test
    void test2DaysRequiredToCollectStonesMethod() {
        //TODO: Версия 2.
        int stones = 5;
        Assertions
                .assertEquals(
                        operationsToTest.daysRequiredToCollectStones(stones),
                        operationsToTest.daysRequiredToCollectStones(5)
                );
    }*/
}