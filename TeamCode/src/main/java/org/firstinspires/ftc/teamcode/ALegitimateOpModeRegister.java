package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;

/**
 * Created by kawaiiPlat on 6/10/2017.
 */

public class ALegitimateOpModeRegister {


    public void register(OpModeManager manager) {
        // Register all the OpModes
        manager.register("Test Mode", ALegitimateClass.class);
    }
}