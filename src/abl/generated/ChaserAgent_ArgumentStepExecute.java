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
         case 10: {
            // move_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 12: {
            // move_2Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 14: {
            // move_3Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 16: {
            // move_4Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 18: {
            // move_5Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 20: {
            // move_6Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 22: {
            // move_7Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 24: {
            // move_8Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
