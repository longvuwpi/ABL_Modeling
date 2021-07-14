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
            int creepID;
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
                              BehavingEntity.constantTrue(creepID = wme__1.getCreep_object_id())
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
                                             __$variableTable.put("creepID", new Integer(creepID));
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
            // fire_3
            boolean creepExists;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creepExists = wme__0.getCreep_exists())
                  )

                  {
                        if (
                           creepExists == false
                        )

                        {
                           __$variableTable.put("creepExists", new Boolean(creepExists));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 4: {
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
         case 5: {
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
         case 7: {
            // move_1
            boolean creepExists;
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
                              BehavingEntity.constantTrue(creepExists = wme__1.getCreep_exists())
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
                                             creepExists == true
                                          )

                                          {
                                                if (
                                                   creepInRange == true
                                                )

                                                {
                                                   __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                   __$variableTable.put("creepExists", new Boolean(creepExists));
                                                   __$variableTable.put("playerID", new Integer(playerID));
                                                   return true;
                                                }


                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 8: {
            // move_2
            boolean creepExists;
            int playerID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(creepExists = wme__0.getCreep_exists())
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
                                    creepExists == false
                                 )

                                 {
                                    __$variableTable.put("creepExists", new Boolean(creepExists));
                                    __$variableTable.put("playerID", new Integer(playerID));
                                    return true;
                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 9: {
            // move_3
            int playerDy;
            int creepY;
            int playerY;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerY = wme__0.getPlayer_location_y())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDy = wme__1.getPlayer_trajectory_dy())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepY = wme__3.getCreep_location_y())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepY >(playerY - playerDy)
                                                                  )

                                                                  {
                                                                        if (
                                                                           creepY <(playerY + playerDy)
                                                                        )

                                                                        {
                                                                           __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                           __$variableTable.put("playerDy", new Integer(playerDy));
                                                                           __$variableTable.put("playerY", new Integer(playerY));
                                                                           __$variableTable.put("creepY", new Integer(creepY));
                                                                           __$variableTable.put("playerID", new Integer(playerID));
                                                                           return true;
                                                                        }


                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 10: {
            // move_4
            int playerX;
            int playerDx;
            int creepX;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerX = wme__0.getPlayer_location_x())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDx = wme__1.getPlayer_trajectory_dx())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepX = wme__3.getCreep_location_x())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepX >(playerX - playerDx)
                                                                  )

                                                                  {
                                                                        if (
                                                                           creepX <(playerX + playerDx)
                                                                        )

                                                                        {
                                                                           __$variableTable.put("creepX", new Integer(creepX));
                                                                           __$variableTable.put("playerX", new Integer(playerX));
                                                                           __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                           __$variableTable.put("playerDx", new Integer(playerDx));
                                                                           __$variableTable.put("playerID", new Integer(playerID));
                                                                           return true;
                                                                        }


                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 11: {
            // move_5
            int playerDy;
            int creepY;
            int playerY;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerY = wme__0.getPlayer_location_y())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDy = wme__1.getPlayer_trajectory_dy())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepY = wme__3.getCreep_location_y())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepY <=(playerY - playerDy)
                                                                  )

                                                                  {
                                                                     __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                     __$variableTable.put("playerDy", new Integer(playerDy));
                                                                     __$variableTable.put("playerY", new Integer(playerY));
                                                                     __$variableTable.put("creepY", new Integer(creepY));
                                                                     __$variableTable.put("playerID", new Integer(playerID));
                                                                     return true;
                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 12: {
            // move_6
            int playerDy;
            int creepY;
            int playerY;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerY = wme__0.getPlayer_location_y())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDy = wme__1.getPlayer_trajectory_dy())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepY = wme__3.getCreep_location_y())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepY >=(playerY + playerDy)
                                                                  )

                                                                  {
                                                                     __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                     __$variableTable.put("playerDy", new Integer(playerDy));
                                                                     __$variableTable.put("playerY", new Integer(playerY));
                                                                     __$variableTable.put("creepY", new Integer(creepY));
                                                                     __$variableTable.put("playerID", new Integer(playerID));
                                                                     return true;
                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 13: {
            // move_7
            int playerX;
            int playerDx;
            int creepX;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerX = wme__0.getPlayer_location_x())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDx = wme__1.getPlayer_trajectory_dx())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepX = wme__3.getCreep_location_x())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepX <=(playerX - playerDx)
                                                                  )

                                                                  {
                                                                     __$variableTable.put("creepX", new Integer(creepX));
                                                                     __$variableTable.put("playerX", new Integer(playerX));
                                                                     __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                     __$variableTable.put("playerDx", new Integer(playerDx));
                                                                     __$variableTable.put("playerID", new Integer(playerID));
                                                                     return true;
                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 14: {
            // move_8
            int playerX;
            int playerDx;
            int creepX;
            int playerID;
            boolean creepInRange;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(playerX = wme__0.getPlayer_location_x())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(playerDx = wme__1.getPlayer_trajectory_dx())
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
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                             if (
                                                BehavingEntity.constantTrue(creepX = wme__3.getCreep_location_x())
                                             )

                                             {
                                                   List wmeList4;
                                                   ListIterator wmeIter4;
                                                   wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                                   wmeIter4 = wmeList4.listIterator();
                                                   while(wmeIter4.hasNext()) {
                                                      PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                      if (
                                                         BehavingEntity.constantTrue(creepInRange = wme__4.getIsInRangeOfCreep())
                                                      )

                                                      {
                                                            if (
                                                               creepInRange == false
                                                            )

                                                            {
                                                                  if (
                                                                     creepX >=(playerX + playerDx)
                                                                  )

                                                                  {
                                                                     __$variableTable.put("creepX", new Integer(creepX));
                                                                     __$variableTable.put("playerX", new Integer(playerX));
                                                                     __$variableTable.put("creepInRange", new Boolean(creepInRange));
                                                                     __$variableTable.put("playerDx", new Integer(playerDx));
                                                                     __$variableTable.put("playerID", new Integer(playerID));
                                                                     return true;
                                                                  }


                                                            }


                                                      }

                                                   }


                                             }

                                          }


                                    }

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
