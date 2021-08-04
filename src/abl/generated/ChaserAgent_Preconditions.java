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
public class ChaserAgent_Preconditions {
   static public boolean precondition0(int __$behaviorID, Object[] __$args, Hashtable __$variableTable, final BehavingEntity __$thisEntity) {
      switch (__$behaviorID) {
         case 1: {
            // fire_1
            int campID;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creepInRange = wme__0.getIsInRangeOfCreep())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(campID = wme__1.getTarget_camp_id())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(playerID = wme__2.getPlayer_object_id())
                                    )

                                    {
                                          if (
                                             creepInRange == true
                                          )

                                          {
                                             __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                             __$variableTable.put("campID", new Integer(campID));
                                             __$variableTable.put("playerID", new Integer(playerID));
                                             return true;
                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 2: {
            // fire_2
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creepInRange = wme__0.getIsInRangeOfCreep())
                  )

                  {
                        if (
                           creepInRange == false
                        )

                        {
                           __$variableTable.put("creepInRange", new Boolean(creepInRange));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 3: {
            // creep_fire_1
            boolean creep_aggroed;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CreepWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CreepWME wme__0 = (CreepWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creep_aggroed = wme__0.getIs_aggroed())
                  )

                  {
                        if (
                           creep_aggroed == false
                        )

                        {
                           __$variableTable.put("creep_aggroed", new Boolean(creep_aggroed));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 4: {
            // creep_fire_2
            boolean creep_aggroed;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CreepWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CreepWME wme__0 = (CreepWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creep_aggroed = wme__0.getIs_aggroed())
                  )

                  {
                        if (
                           creep_aggroed == true
                        )

                        {
                           __$variableTable.put("creep_aggroed", new Boolean(creep_aggroed));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 6: {
            // move_1
            int targetCamp;
            int playerID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(targetCamp = wme__0.getSelected_camp())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerID = wme__1.getPlayer_object_id())
                           )

                           {
                                 if (
                                    targetCamp != -1
                                 )

                                 {
                                    __$variableTable.put("targetCamp", new Integer(targetCamp));
                                    __$variableTable.put("playerID", new Integer(playerID));
                                    return true;
                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 7: {
            // move_2
            int targetCamp;
            int playerID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(targetCamp = wme__0.getSelected_camp())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerID = wme__1.getPlayer_object_id())
                           )

                           {
                                 if (
                                    targetCamp == -1
                                 )

                                 {
                                    __$variableTable.put("targetCamp", new Integer(targetCamp));
                                    __$variableTable.put("playerID", new Integer(playerID));
                                    return true;
                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 8: {
            // seek_safety_1
            boolean playerInDanger;
            int playerID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerID = wme__0.getPlayer_object_id())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerInDanger = wme__1.getIs_in_danger())
                           )

                           {
                                 if (
                                    playerInDanger == true
                                 )

                                 {
                                    __$variableTable.put("playerInDanger", new Boolean(playerInDanger));
                                    __$variableTable.put("playerID", new Integer(playerID));
                                    return true;
                                 }


                           }

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
