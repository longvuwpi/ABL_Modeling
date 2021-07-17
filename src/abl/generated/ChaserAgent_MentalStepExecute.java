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
            break;
         }
         case 4: {
            // fire_3Step1
            break;
         }
         case 5: {
            // creep_fire_1Step1
            break;
         }
         case 7: {
            // creep_fire_2Step1
            System.out.println("Creep aggroed, firing");
            break;
         }
         case 10: {
            // move_1Step1
            System.out.println("Moving to creep");
            break;
         }
         case 13: {
            // Wait_1Step1
            ((__ValueTypes.LongVar)__$behaviorFrame[1]).l = System.currentTimeMillis() + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i;
            break;
         }
         case 23: {
            // ChaserAgent_RootCollectionBehaviorStep1
            System.out.println("Starting Chaser Agent");
            break;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
