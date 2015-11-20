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
    final static double MOTOR_POWER = 0.15; // Higher values will cause the robot to move faster
    final static double Motor_Power_Down = -0.15;

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
        motorBackArticulator = hardwareMap.dcMotor.get("back_articulator");
        motorFrontArticulator = hardwareMap.dcMotor.get("f_a");
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

       motorFrontRight.setPower(MOTOR_POWER);
       motorFrontLeft.setPower(MOTOR_POWER);
       motorBackLeft.setPower(MOTOR_POWER);
       motorBackRight.setPower(MOTOR_POWER);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                motorFrontRight.setPower(0.0);
                motorBackRight.setPower(0.0);
                motorFrontLeft.setPower(0.0);
                motorBackLeft.setPower(0.0);

            }

        }, 30000);





//                motorBack.setPower
//                motorRight.setPower(MOTOR_POWER);
//                motorLeft.setPower(MOTOR_POWER);
    }
}
