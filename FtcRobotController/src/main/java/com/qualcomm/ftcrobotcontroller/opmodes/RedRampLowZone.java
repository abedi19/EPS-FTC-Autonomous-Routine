package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 12/3/2015.
 */
public class RedRampLowZone extends OpMode {
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


    @Override
    public void init () {
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
        motorBackArticulator = hardwareMap.dcMotor.get("back_up");
        motorFrontArticulator = hardwareMap.dcMotor.get("front_up");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left_drive");
        motorFrontRight = hardwareMap.dcMotor.get("front_right_drive");
        motorBackLeft = hardwareMap.dcMotor.get("back_left_drive");
        motorBackRight = hardwareMap.dcMotor.get("back_right_drive");


    }

    @Override
    public void start () {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.forward();

            }
        },15000) ; // start driving 15sec post comp


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.turnLeft();
            }
        }, 20000); // stop driving at second 20 and start turning left

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.forward();
            }
        }, 21000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               helper.stopMoving();
                motorFrontArticulator.setPower(MOTOR_POWER);
            }
        }, 21000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                motorFrontArticulator.setPower(0.0);
            }
        },21500);
    }

    @Override
    public void loop () {


    }

}
