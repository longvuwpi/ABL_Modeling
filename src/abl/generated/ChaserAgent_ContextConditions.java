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
public class ChaserAgent_ContextConditions {
   static public boolean contextCondition0(int __$behaviorID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$behaviorID) {
         case 1: {
            // fire_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[3]).b = wme__0.getIs_in_danger())
                  )

                  {
                        if (
                           ((__ValueTypes.BooleanVar)__$behaviorFrame[3]).b == false
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 6: {
            // move_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[2]).b = wme__0.getBelief_is_consistent())
                  )

                  {
                        if (
                           ((__ValueTypes.BooleanVar)__$behaviorFrame[2]).b == true
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
