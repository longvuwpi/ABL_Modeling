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
public class ChaserAgent_ArgumentStepExecute {
   static public Object[] argumentExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$stepID) {
         case 2: {
            // fire_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 6: {
            // creep_fire_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(100);
            return args;
         }
         case 11: {
            // move_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 12: {
            // move_2Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(50);
            return args;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
