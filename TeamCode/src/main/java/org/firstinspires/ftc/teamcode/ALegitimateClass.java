package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by captainFlareon 6/10/2017.
 */

@TeleOp(name = "Driver Control", group = "TeleOp")
public class ALegitimateClass extends OpMode {

    // Hardware map initialization.
    ALegitimateHardwareClass hardware = new ALegitimateHardwareClass();
    // Speed modifer variables
    double driverSpeedMod               = NORMAL;
    double utilitySpeedMod              = NORMAL;

    public static final double SLOW     = 0.4;
    public static final double NORMAL   = 0.7;
    public static final double FAST     = 1.0;


    @Override
    public void init() {

        telemetry.addLine("Initializing hardware... do not press play!");
        telemetry.update();

        hardware.init(hardwareMap);

        telemetry.addLine("Hardware initialized.");
        telemetry.update();
    }


    @Override
    public void init_loop() {}


    @Override
    public void start() {}


    @Override
    public void loop() {
        // Handle speed modifiers
        if(gamepad1.left_bumper)        driverSpeedMod = FAST;
        else if(gamepad1.right_bumper)  driverSpeedMod = SLOW;
        else                            driverSpeedMod = NORMAL;

        if(gamepad2.left_bumper)        utilitySpeedMod = FAST;
        else if(gamepad2.right_bumper)  utilitySpeedMod = SLOW;
        else                            utilitySpeedMod = NORMAL;

        // Handle drive motors
        hardware.leftDrive1.setPower(gamepad1.left_stick_y * driverSpeedMod);
        hardware.leftDrive2.setPower(gamepad1.left_stick_y * driverSpeedMod);

        hardware.rightDrive1.setPower(gamepad1.right_stick_y * driverSpeedMod);
        hardware.rightDrive2.setPower(gamepad1.right_stick_y * driverSpeedMod);

        hardware.lifter.setPower(gamepad2.right_stick_y * utilitySpeedMod);

        if(gamepad2.x)
            hardware.particleServo.setPosition(0.3);
        else if(gamepad2.y)
            hardware.particleServo.setPosition(0.5);
        else
            hardware.particleServo.setPosition(0.4);

        // Update telemetry
        telemetry.addData("Runtime", getRuntime());
        telemetry.addLine();
        telemetry.addData("Left ODS", hardware.leftODS.getLightDetected());
        telemetry.addData("RIght ODS", hardware.rightODS.getLightDetected());
        telemetry.addLine();
        telemetry.addData("Front touch sensor", hardware.frontTouch);
        telemetry.addData("Debug touch sensor", hardware.debugTouch);
        telemetry.addLine();
        telemetry.addData("Driver Speed Mod",  driverSpeedMod);
        telemetry.addData("Utility Speed Mod",  utilitySpeedMod);
        telemetry.addLine();
        telemetry.addData("Blue", hardware.colorSensor.blue());
        telemetry.addData("Red", hardware.colorSensor.red());
        telemetry.update();
    }
}