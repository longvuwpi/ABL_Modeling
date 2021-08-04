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
public class ChaserAgent_BehaviorFactories {
   static public Behavior behaviorFactory0(int __$behaviorID, Object[] __$args, Hashtable __$boundVars, GoalStep __$parentGoal, String __$signature) {
      switch (__$behaviorID) {
         case 0: {
            // manageFiring_1

            final __StepDesc[] __$steps = {new __StepDesc(0, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, true, __$signature, (short)0, 0, null, __$steps);
         }
         case 1: {
            // fire_1
               final Object[] __$behaviorFrame = new Object[4];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("campID"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[2] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));
               __$behaviorFrame[3] = new __ValueTypes.BooleanVar();

            final __StepDesc[] __$steps = {new __StepDesc(1, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(2, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, ChaserAgent.__$contextCondition0_rfield, ChaserAgent.__$contextConditionSensorFactory0_rfield, null, null, false, __$signature, (short)1, 1, __$behaviorFrame, __$steps);
         }
         case 2: {
            // fire_2
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(3, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 2, __$behaviorFrame, __$steps);
         }
         case 3: {
            // creep_fire_1
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_aggroed"));

            final __StepDesc[] __$steps = {new __StepDesc(4, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(5, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 3, __$behaviorFrame, __$steps);
         }
         case 4: {
            // creep_fire_2
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_aggroed"));

            final __StepDesc[] __$steps = {new __StepDesc(6, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(7, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 4, __$behaviorFrame, __$steps);
         }
         case 5: {
            // manageMovement_1

            final __StepDesc[] __$steps = {new __StepDesc(8, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, true, __$signature, (short)0, 5, null, __$steps);
         }
         case 6: {
            // move_1
               final Object[] __$behaviorFrame = new Object[3];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("targetCamp"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[2] = new __ValueTypes.BooleanVar();

            final __StepDesc[] __$steps = {new __StepDesc(9, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(10, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, ChaserAgent.__$contextCondition0_rfield, ChaserAgent.__$contextConditionSensorFactory0_rfield, null, null, false, __$signature, (short)3, 6, __$behaviorFrame, __$steps);
         }
         case 7: {
            // move_2
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("targetCamp"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));

            final __StepDesc[] __$steps = {new __StepDesc(11, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(12, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 7, __$behaviorFrame, __$steps);
         }
         case 8: {
            // seek_safety_1
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("playerInDanger"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));

            final __StepDesc[] __$steps = {new __StepDesc(13, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(14, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)3, 8, __$behaviorFrame, __$steps);
         }
         case 9: {
            // seek_safety_2

            final __StepDesc[] __$steps = {new __StepDesc(15, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(-1, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 9, null, __$steps);
         }
         case 10: {
            // Wait_1
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$args[0]);
               __$behaviorFrame[1] = new __ValueTypes.LongVar();

            final __StepDesc[] __$steps = {new __StepDesc(16, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(17, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 10, __$behaviorFrame, __$steps);
         }
         case 11: {
            // player_behavior_1

            final __StepDesc[] __$steps = {new __StepDesc(18, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(19, ChaserAgent.__$stepFactory0_rfield)};
            return new ParallelBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 11, null, __$steps, 2);
         }
         case 12: {
            // creep_behavior_1

            final __StepDesc[] __$steps = {new __StepDesc(20, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, true, __$signature, (short)0, 12, null, __$steps);
         }
         case 13: {
            // beginAction_1

            final __StepDesc[] __$steps = {new __StepDesc(21, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(22, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(23, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 13, null, __$steps);
         }
         case 14: {
            // player_1

            final __StepDesc[] __$steps = {new __StepDesc(24, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(25, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(26, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 14, null, __$steps);
         }
         case 15: {
            // ChaserAgent_RootCollectionBehavior

            final __StepDesc[] __$steps = {new __StepDesc(27, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(28, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(29, ChaserAgent.__$stepFactory0_rfield)};
            return new CollectionBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 15, null, __$steps, 3);
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
