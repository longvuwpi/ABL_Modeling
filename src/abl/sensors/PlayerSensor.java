package abl.sensors;

import game.Chaser;
import abl.runtime.BehavingEntity;
import abl.wmes.PlayerWME;
import wm.WME;
import java.util.LinkedList;

/**
 * Adds a PlayerWME object to working memory when sense in invoked.
 *
 * @author Ben Weber 3-7-11
 */
public class PlayerSensor extends SerialSensor {

    /**
     * Adds a Player WME to working memory of the agent and deletes previous
     * player WMEs in memory.
     */
    protected void sense() {
        //BehavingEntity.getBehavingEntity().deleteAllWMEClass("PlayerWME");
        //BehavingEntity.getBehavingEntity().addWME(
        //		new PlayerWME(Chaser.getInstance().getPlayerLocation(), Chaser.getInstance().getPlayerTrajectory()));
        LinkedList<WME> player_WME = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
        if (player_WME.isEmpty() || (player_WME.size() > 1)) {
            BehavingEntity.getBehavingEntity().deleteAllWMEClass("PlayerWME");

            //System.out.println("adding new WME");
            BehavingEntity.getBehavingEntity().addWME(
                    new PlayerWME());
        } else {
            //System.out.println("Updating values in WME, there are " + player_WME.size() + " instances");
            for (WME each_wme : player_WME) {
                ((PlayerWME) each_wme).updateAndStore();

            }
        }
    }
}
