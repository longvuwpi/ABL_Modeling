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
public class ChaserAgent_SuccessTests {
   static public boolean successTest0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$stepID) {
         case 17: {
            // Wait_1Step2
               if (
                  System.currentTimeMillis() > ((__ValueTypes.LongVar)__$behaviorFrame[1]).l
               )

               {
                  return true;
               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
