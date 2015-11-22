package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LegacyModule;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/20/2015.
 */
public class Autonamous_Turn_Right extends OpMode {
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
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
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


        Timer timer = new Timer();


        // drive a cross mountain post 15 sec delay for 3 seconds
        timer.schedule(new TimerTask() {

            public void run() {
                motorFrontLeft.setPower(MOTOR_POWER);
                motorFrontRight.setPower(MOTOR_POWER);
                motorBackLeft.setPower(MOTOR_POWER);
                motorBackRight.setPower(Motor_Power_Reverse);
            }

        }, 15000);

        // turn right in 0.5 sec
        timer.schedule(new TimerTask() {

            public void run() {
                motorFrontLeft.setPower(MOTOR_POWER);
                motorFrontRight.setPower(Motor_Power_Reverse);
                motorBackLeft.setPower(MOTOR_POWER);
                motorBackRight.setPower(MOTOR_POWER);
            }

        }, 18000);

        // drive up mountain for 3 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                motorBackLeft.setPower(MOTOR_POWER);
                motorFrontLeft.setPower(MOTOR_POWER);
                motorFrontLeft.setPower(MOTOR_POWER);
                motorBackRight.setPower(Motor_Power_Reverse);

            }
        }, 18500);

        // lower the top treads and raise the bottom treads for 0. 5 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               motorBackArticulator.setPower(Motor_Power_Reverse);
               motorFrontArticulator.setPower(MOTOR_POWER);
            }
        }, 21500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                motorBackLeft.setPower(0);
                motorFrontLeft.setPower(0);
                motorBackRight.setPower(0);
                motorFrontRight.setPower(0);
                motorBackArticulator.setPower(0);
                motorFrontArticulator.setPower(0);
            }
        }, 22000);


    }
    @Override
    public void stop() {
        Timer endClock = new Timer();
        endClock.schedule(new TimerTask() {
            @Override
            public void run() {
                motorBackLeft.setPower(0);
                motorFrontLeft.setPower(0);
                motorBackRight.setPower(0);
                motorFrontRight.setPower(0);
                motorBackArticulator.setPower(0);
                motorFrontArticulator.setPower(0);
            }
        }, 22100);
    }
}