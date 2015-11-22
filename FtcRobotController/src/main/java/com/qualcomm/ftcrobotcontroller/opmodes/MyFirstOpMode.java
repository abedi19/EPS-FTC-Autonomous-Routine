package com.qualcomm.ftcrobotcontroller.opmodes;

import android.content.Intent;

import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
import com.qualcomm.robotcore.hardware.LegacyModule;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A skeletal example of a do-nothing first OpMode. Go ahead and change this code
 * to suit your needs, or create sibling OpModes adjacent to this one in the same
 * Java package.
 */
public class MyFirstOpMode extends OpMode {

    final static double MOTOR_POWER = 0.15; // Higher values will cause the robot to move faster
    final static double Motor_Power_Down = -0.15;

    // final static double HOLD_IR_SIGNAL_STRENGTH = 0.20; // Higher values will cause the robot to follow closer

    LegacyModule legacyOne;
    LegacyModule motorBack;
    DcMotor motorBackArticulator;
    DcMotor motorFrontArticulator;
    DcMotor motorLeft;
    Servo armSpinny;

    @Override
    public void init() {
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
        motorBackArticulator = hardwareMap.dcMotor.get("back_legs");
        motorFrontArticulator = hardwareMap.dcMotor.get("front_legs");

    }

    @Override
    public void start() {

//        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        // full power

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                motorBackArticulator.setPower(MOTOR_POWER);
                motorFrontArticulator.setPower(MOTOR_POWER);
            }

        }, 15000);

//                motorBack.setPower
//                motorRight.setPower(MOTOR_POWER);
//                motorLeft.setPower(MOTOR_POWER);
    }
}

