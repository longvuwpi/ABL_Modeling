package abl.generated;

import abl.runtime.*;
import wm.WME;
import java.util.*;
import java.lang.reflect.Method;
import abl.learning.*;
import abl.actions.*;
import abl.sensors.*;
import abl.wmes.CreepWME;
import abl.wmes.PlayerWME;
import java.awt.Point;
public class ChaserAgent_StepFactories {
   static public Step stepFactory0(int __$stepID, Behavior __$behaviorParent, final Object[] __$behaviorFrame) {
      switch (__$stepID) {
         case -3: {
            // default wait step
            return new WaitStep(-3, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null);
         }
         case -2: {
            // default fail step
            return new FailStep(-2, __$behaviorParent, false, false, false, (short)-32768, (short)0, false, null, null);
         }
         case -1: {
            // default succeed step
            return new SucceedStep(-1, __$behaviorParent, false, false, (short)-32768, (short)0, false, null, null);
         }
         case 0: {
            // manageFiring_1Step1
            return new GoalStep(0, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 1: {
            // fire_1Step1
            return new MentalStep(1, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 2: {
            // fire_1Step2
            return new PrimitiveStep(2, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new Fire(), null, "fire");
         }
         case 3: {
            // fire_2Step1
            return new MentalStep(3, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 4: {
            // fire_3Step1
            return new MentalStep(4, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 5: {
            // creep_fire_1Step1
            return new MentalStep(5, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 6: {
            // creep_fire_2Step1
            return new MentalStep(6, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 7: {
            // creep_fire_3Step1
            return new MentalStep(7, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 8: {
            // creep_fire_3Step2
            return new PrimitiveStep(8, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new Fire(), null, "fire");
         }
         case 9: {
            // manageMovement_1Step1
            return new GoalStep(9, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 10: {
            // move_1Step1
            return new MentalStep(10, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 11: {
            // move_1Step2
            return new PrimitiveStep(11, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new Stop(), null, "stop");
         }
         case 12: {
            // move_2Step1
            return new MentalStep(12, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 13: {
            // move_2Step2
            return new PrimitiveStep(13, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new Stop(), null, "stop");
         }
         case 14: {
            // move_3Step1
            return new MentalStep(14, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 15: {
            // move_3Step2
            return new PrimitiveStep(15, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new StopVertical(), null, "stopVertical");
         }
         case 16: {
            // move_4Step1
            return new MentalStep(16, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 17: {
            // move_4Step2
            return new PrimitiveStep(17, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new StopHorizontal(), null, "stopHorizontal");
         }
         case 18: {
            // move_5Step1
            return new MentalStep(18, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 19: {
            // move_5Step2
            return new PrimitiveStep(19, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveUp(), null, "moveUp");
         }
         case 20: {
            // move_6Step1
            return new MentalStep(20, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 21: {
            // move_6Step2
            return new PrimitiveStep(21, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveToBase(), null, "moveDown");
         }
         case 22: {
            // move_7Step1
            return new MentalStep(22, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 23: {
            // move_7Step2
            return new PrimitiveStep(23, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveLeft(), null, "moveLeft");
         }
         case 24: {
            // move_8Step1
            return new MentalStep(24, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 25: {
            // move_8Step2
            return new PrimitiveStep(25, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveRight(), null, "moveRight");
         }
         case 26: {
            // Wait_1Step1
            return new MentalStep(26, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 27: {
            // Wait_1Step2
            return new WaitStep(27, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, ChaserAgent.__$successTest0_rfield, null, null);
         }
         case 28: {
            // player_behavior_1Step1
            return new GoalStep(28, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageFiring()", null, (short)0);
         }
         case 29: {
            // player_behavior_1Step2
            return new GoalStep(29, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageMovement()", null, (short)0);
         }
         case 30: {
            // creep_behavior_1Step1
            return new GoalStep(30, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 31: {
            // beginAction_1Step1
            return new GoalStep(31, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 32: {
            // beginAction_1Step2
            return new GoalStep(32, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 33: {
            // beginAction_1Step3
            return new GoalStep(33, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 34: {
            // ChaserAgent_RootCollectionBehaviorStep1
            return new MentalStep(34, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 35: {
            // ChaserAgent_RootCollectionBehaviorStep2
            return new GoalStep(35, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "beginAction()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
