package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/22/2015.
 */
public class Calculate_Up_Down extends OpMode {
    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;

    // final static double HOLD_IR_SIGNAL_STRENGTH = 0.20; // Higher values will cause the robot to follow closer


    DcMotor motorBackArticulator;
    DcMotor motorFrontArticulator;

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;


    @Override
    public void init() {
        motorBackArticulator = hardwareMap.dcMotor.get("back_legs");
        motorFrontArticulator = hardwareMap.dcMotor.get("front_legs");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left_drive");
        motorFrontRight = hardwareMap.dcMotor.get("front_right_drive");
        motorBackLeft = hardwareMap.dcMotor.get("back_left_drive");
        motorBackRight = hardwareMap.dcMotor.get("back_right_drive");

    }

    @Override
    public void start() {

//        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        // full power

      motorFrontArticulator.setPower(Motor_Power_Reverse);
      motorBackArticulator.setPower(Motor_Power_Reverse);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                motorBackArticulator.setPower(0);
                motorFrontArticulator.setPower(0);
            }
        }, 500);

//
    }

}