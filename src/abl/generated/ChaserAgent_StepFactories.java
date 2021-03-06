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
            // creep_fire_1Step1
            return new MentalStep(4, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 5: {
            // creep_fire_1Step2
            return new GoalStep(5, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, "Wait(int)", null, (short)0);
         }
         case 6: {
            // creep_fire_2Step1
            return new MentalStep(6, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 7: {
            // creep_fire_2Step2
            return new PrimitiveStep(7, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, new CreepAggro(), null, "creep_aggro");
         }
         case 8: {
            // manageMovement_1Step1
            return new GoalStep(8, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 9: {
            // move_1Step1
            return new MentalStep(9, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 10: {
            // move_1Step2
            return new PrimitiveStep(10, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveToObject(), null, "move_to_object");
         }
         case 11: {
            // move_2Step1
            return new MentalStep(11, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 12: {
            // move_2Step2
            return new PrimitiveStep(12, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new GoToBase(), null, "go_to_base");
         }
         case 13: {
            // seek_safety_1Step1
            return new MentalStep(13, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 14: {
            // seek_safety_1Step2
            return new PrimitiveStep(14, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new GoToBase(), null, "go_to_base");
         }
         case 15: {
            // seek_safety_2Step1
            return new MentalStep(15, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 16: {
            // Wait_1Step1
            return new MentalStep(16, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 17: {
            // Wait_1Step2
            return new WaitStep(17, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, ChaserAgent.__$successTest0_rfield, null, null);
         }
         case 18: {
            // player_behavior_1Step1
            return new GoalStep(18, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageFiring()", null, (short)0);
         }
         case 19: {
            // player_behavior_1Step2
            return new GoalStep(19, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageMovement()", null, (short)0);
         }
         case 20: {
            // creep_behavior_1Step1
            return new GoalStep(20, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 21: {
            // beginAction_1Step1
            return new GoalStep(21, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 22: {
            // beginAction_1Step2
            return new GoalStep(22, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 23: {
            // beginAction_1Step3
            return new GoalStep(23, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 24: {
            // player_1Step1
            return new GoalStep(24, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "seek_safety()", null, (short)0);
         }
         case 25: {
            // player_1Step2
            return new GoalStep(25, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 26: {
            // player_1Step3
            return new GoalStep(26, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 27: {
            // ChaserAgent_RootCollectionBehaviorStep1
            return new MentalStep(27, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 28: {
            // ChaserAgent_RootCollectionBehaviorStep2
            return new GoalStep(28, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "player()", null, (short)0);
         }
         case 29: {
            // ChaserAgent_RootCollectionBehaviorStep3
            return new GoalStep(29, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
