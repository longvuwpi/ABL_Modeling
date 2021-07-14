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
public class ChaserAgent_MentalStepExecute {
   static public void mentalExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity, MentalStep __$thisStep) {
      switch (__$stepID) {
         case 1: {
            // fire_1Step1
            System.out.println("Firing");
            break;
         }
         case 3: {
            // fire_2Step1
            System.out.println("Creep not in range, not firing");
            break;
         }
         case 4: {
            // fire_3Step1
            System.out.println("Creep does not exist, not firing");
            break;
         }
         case 5: {
            // creep_fire_1Step1
            System.out.println("Creep idle");
            break;
         }
         case 6: {
            // creep_fire_2Step1
            System.out.println("Creep aggroed, firing");
            break;
         }
         case 9: {
            // move_1Step1
            System.out.println("Stopping");
            break;
         }
         case 11: {
            // move_2Step1
            System.out.println("Creep does not exist, not moving");
            break;
         }
         case 13: {
            // move_3Step1
            System.out.println("stop vertical");
            break;
         }
         case 15: {
            // move_4Step1
            System.out.println("stop horizontal");
            break;
         }
         case 17: {
            // move_5Step1
            System.out.println("Moving up");
            break;
         }
         case 19: {
            // move_6Step1
            System.out.println("Moving down");
            break;
         }
         case 21: {
            // move_7Step1
            System.out.println("Moving left");
            break;
         }
         case 23: {
            // move_8Step1
            System.out.println("Moving right");
            break;
         }
         case 25: {
            // Wait_1Step1
            ((__ValueTypes.LongVar)__$behaviorFrame[1]).l = System.currentTimeMillis() + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i;
            break;
         }
         case 33: {
            // ChaserAgent_RootCollectionBehaviorStep1
            System.out.println("Starting Chaser Agent");
            break;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
