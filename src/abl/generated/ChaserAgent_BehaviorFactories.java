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
               final Object[] __$behaviorFrame = new Object[3];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepID"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[2] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(1, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(2, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)1, 1, __$behaviorFrame, __$steps);
         }
         case 2: {
            // fire_2
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(3, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 2, __$behaviorFrame, __$steps);
         }
         case 3: {
            // fire_3
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepExists"));

            final __StepDesc[] __$steps = {new __StepDesc(4, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 3, __$behaviorFrame, __$steps);
         }
         case 4: {
            // creep_fire_1
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_aggroed"));
               __$behaviorFrame[1] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_dead"));

            final __StepDesc[] __$steps = {new __StepDesc(5, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 4, __$behaviorFrame, __$steps);
         }
         case 5: {
            // creep_fire_2
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_dead"));

            final __StepDesc[] __$steps = {new __StepDesc(6, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(-2, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 5, __$behaviorFrame, __$steps);
         }
         case 6: {
            // creep_fire_3
               final Object[] __$behaviorFrame = new Object[3];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creep_aggroed"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("attackerid"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepid"));

            final __StepDesc[] __$steps = {new __StepDesc(7, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(8, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 6, __$behaviorFrame, __$steps);
         }
         case 7: {
            // manageMovement_1

            final __StepDesc[] __$steps = {new __StepDesc(9, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, true, __$signature, (short)0, 7, null, __$steps);
         }
         case 8: {
            // move_1
               final Object[] __$behaviorFrame = new Object[3];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepExists"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[2] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(10, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(11, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)3, 8, __$behaviorFrame, __$steps);
         }
         case 9: {
            // move_2
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepExists"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));

            final __StepDesc[] __$steps = {new __StepDesc(12, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(13, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)3, 9, __$behaviorFrame, __$steps);
         }
         case 10: {
            // move_3
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDy"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepY"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerY"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(14, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(15, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)3, 10, __$behaviorFrame, __$steps);
         }
         case 11: {
            // move_4
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerX"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDx"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepX"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(16, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(17, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)3, 11, __$behaviorFrame, __$steps);
         }
         case 12: {
            // move_5
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDy"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepY"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerY"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(18, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(19, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 12, __$behaviorFrame, __$steps);
         }
         case 13: {
            // move_6
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDy"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepY"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerY"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(20, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(21, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 13, __$behaviorFrame, __$steps);
         }
         case 14: {
            // move_7
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerX"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDx"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepX"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(22, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(23, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 14, __$behaviorFrame, __$steps);
         }
         case 15: {
            // move_8
               final Object[] __$behaviorFrame = new Object[5];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerX"));
               __$behaviorFrame[1] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerDx"));
               __$behaviorFrame[2] = new __ValueTypes.IntVar((Integer)__$boundVars.get("creepX"));
               __$behaviorFrame[3] = new __ValueTypes.IntVar((Integer)__$boundVars.get("playerID"));
               __$behaviorFrame[4] = new __ValueTypes.BooleanVar((Boolean)__$boundVars.get("creepInRange"));

            final __StepDesc[] __$steps = {new __StepDesc(24, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(25, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)2, 15, __$behaviorFrame, __$steps);
         }
         case 16: {
            // Wait_1
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$args[0]);
               __$behaviorFrame[1] = new __ValueTypes.LongVar();

            final __StepDesc[] __$steps = {new __StepDesc(26, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(27, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 16, __$behaviorFrame, __$steps);
         }
         case 17: {
            // player_behavior_1

            final __StepDesc[] __$steps = {new __StepDesc(28, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(29, ChaserAgent.__$stepFactory0_rfield)};
            return new ParallelBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 17, null, __$steps, 2);
         }
         case 18: {
            // creep_behavior_1

            final __StepDesc[] __$steps = {new __StepDesc(30, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, true, __$signature, (short)0, 18, null, __$steps);
         }
         case 19: {
            // beginAction_1

            final __StepDesc[] __$steps = {new __StepDesc(31, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(32, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(33, ChaserAgent.__$stepFactory0_rfield)};
            return new SequentialBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 19, null, __$steps);
         }
         case 20: {
            // ChaserAgent_RootCollectionBehavior

            final __StepDesc[] __$steps = {new __StepDesc(34, ChaserAgent.__$stepFactory0_rfield), new __StepDesc(35, ChaserAgent.__$stepFactory0_rfield)};
            return new CollectionBehavior(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 20, null, __$steps, 2);
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
