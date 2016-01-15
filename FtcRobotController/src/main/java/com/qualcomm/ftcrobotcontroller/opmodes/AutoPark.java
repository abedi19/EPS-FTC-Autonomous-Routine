package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/22/2015.
 */
public class AutoPark extends  OpMode{

    // start copy

    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;

    // final static double HOLD_IR_SIGNAL_STRENGTH = 0.20; // Higher values will cause the robot to follow closer


    DcMotor motorBackArticulator;
    DcMotor motorFrontArticulator;

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;

    Helper helper = new Helper();
    DcMotor[] motors = {motorBackArticulator, motorFrontArticulator, motorBackLeft, motorBackRight, motorFrontLeft, motorFrontRight};


    @Override
    public void init () {
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
        motorBackArticulator = hardwareMap.dcMotor.get("back_legs");
        motorFrontArticulator = hardwareMap.dcMotor.get("front_legs");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left_drive");
        motorFrontRight = hardwareMap.dcMotor.get("front_right_drive");
        motorBackLeft = hardwareMap.dcMotor.get("back_left_drive");
        motorBackRight = hardwareMap.dcMotor.get("back_right_drive");
        
    } // end copy

    @Override
    public void start () {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               helper.forward(motors);

            }
        },15000) ;


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.stopMoving(motors);
            }
        }, 25000);
    }

    @Override
    public void loop () {



    }

}
