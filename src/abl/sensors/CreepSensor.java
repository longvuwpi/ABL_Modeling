package abl.sensors;

import game.Chaser;
import abl.runtime.BehavingEntity;
import abl.wmes.CreepWME;
import abl.wmes.PlayerWME;
import java.util.LinkedList;
import wm.WME;

/**
 * Adds a ChaserWME object to working memory when sense in invoked.
 *
 * @author Ben Weber 3-7-11
 */
public class CreepSensor extends SerialSensor {

    /**
     * Adds a Chaser WME to working memory of the agent and deletes previous
     * chaser WMEs in memory.
     */
    public void sense() {

        //BehavingEntity.getBehavingEntity().deleteAllWMEClass("ChaserWME");
        //BehavingEntity.getBehavingEntity().addWME(new CreepWME(Chaser.getInstance().getChaserLocation(), Chaser.getInstance().getChaserTrajectory()));
        LinkedList<WME> creep_WME = BehavingEntity.getBehavingEntity().lookupWME("CreepWME");
        if (creep_WME.isEmpty() || (creep_WME.size() > 1)) {
            //System.out.println("adding new creep WME");
            BehavingEntity.getBehavingEntity().deleteAllWMEClass("CreepWME");
            BehavingEntity.getBehavingEntity().addWME(
                    new CreepWME());
        } else {
            //System.out.println("Updating values in creep WME, there are " + creep_WME.size() + " instances");
            for (WME each_wme : creep_WME) {
                ((CreepWME) each_wme).updateAndStore();

            }
        }
    }
    
    @Override
    public void senseContinuous() {
        sense();
    }
}
