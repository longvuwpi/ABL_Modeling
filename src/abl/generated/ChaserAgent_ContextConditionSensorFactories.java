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
public class ChaserAgent_ContextConditionSensorFactories {
   static public SensorActivation[] contextConditionSensorFactory0(int __$behaviorID) {
      switch (__$behaviorID) {
         case 1: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 6: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
