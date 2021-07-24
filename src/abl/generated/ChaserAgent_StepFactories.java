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
            // creep_fire_1Step2
            return new GoalStep(6, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, "Wait(int)", null, (short)0);
         }
         case 7: {
            // creep_fire_2Step1
            return new MentalStep(7, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 8: {
            // creep_fire_2Step2
            return new PrimitiveStep(8, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, new CreepAggro(), null, "creep_aggro");
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
            return new PrimitiveStep(11, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new MoveToObject(), null, "move_to_object");
         }
         case 12: {
            // move_2Step1
            return new GoalStep(12, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, "Wait(int)", null, (short)0);
         }
         case 13: {
            // seek_safety_1Step1
            return new PrimitiveStep(13, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$argumentExecute0_rfield, null, null, null, new GoToBase(), null, "go_to_base");
         }
         case 14: {
            // Wait_1Step1
            return new MentalStep(14, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 15: {
            // Wait_1Step2
            return new WaitStep(15, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, ChaserAgent.__$successTest0_rfield, null, null);
         }
         case 16: {
            // player_behavior_1Step1
            return new GoalStep(16, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageFiring()", null, (short)0);
         }
         case 17: {
            // player_behavior_1Step2
            return new GoalStep(17, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageMovement()", null, (short)0);
         }
         case 18: {
            // creep_behavior_1Step1
            return new GoalStep(18, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 19: {
            // beginAction_1Step1
            return new GoalStep(19, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 20: {
            // beginAction_1Step2
            return new GoalStep(20, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 21: {
            // beginAction_1Step3
            return new GoalStep(21, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
         case 22: {
            // player_1Step1
            return new GoalStep(22, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "seek_safety()", null, (short)0);
         }
         case 23: {
            // player_1Step2
            return new GoalStep(23, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "move()", null, (short)0);
         }
         case 24: {
            // player_1Step3
            return new GoalStep(24, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fire()", null, (short)0);
         }
         case 25: {
            // ChaserAgent_RootCollectionBehaviorStep1
            return new MentalStep(25, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, ChaserAgent.__$mentalExecute0_rfield, null, null, null);
         }
         case 26: {
            // ChaserAgent_RootCollectionBehaviorStep2
            return new GoalStep(26, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "player()", null, (short)0);
         }
         case 27: {
            // ChaserAgent_RootCollectionBehaviorStep3
            return new GoalStep(27, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "creep_fire()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
