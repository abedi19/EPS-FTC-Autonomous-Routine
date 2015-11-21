package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/20/2015.
 */
public class RobotDrive extends OpMode {
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

        if (gamepad1.dpad_up) {
            motorFrontLeft.setPower(MOTOR_POWER);
            motorFrontRight.setPower(MOTOR_POWER);
            motorBackLeft.setPower(MOTOR_POWER);
            motorBackRight.setPower(MOTOR_POWER);
    }

        if (gamepad1.dpad_down) {
            motorFrontLeft.setPower(Motor_Power_Reverse);
            motorFrontRight.setPower(Motor_Power_Reverse);
            motorBackLeft.setPower(Motor_Power_Reverse);
            motorBackRight.setPower(Motor_Power_Reverse);
    }

        if (gamepad1.dpad_right) {
            motorFrontLeft.setPower(MOTOR_POWER);
            motorFrontRight.setPower(Motor_Power_Reverse);
            motorBackLeft.setPower(MOTOR_POWER);
            motorBackRight.setPower(Motor_Power_Reverse);
        }

        if (gamepad1.dpad_left) {
            motorFrontLeft.setPower(Motor_Power_Reverse);
            motorFrontRight.setPower(MOTOR_POWER);
            motorBackLeft.setPower(Motor_Power_Reverse);
            motorBackRight.setPower(MOTOR_POWER);
        }

        if (gamepad1.left_bumper) {
            motorFrontArticulator.setPower(MOTOR_POWER);
        }
        if (gamepad1.right_bumper) {
            motorFrontArticulator.setPower(Motor_Power_Reverse);
        }

        if (gamepad1.left_trigger > 0.25) {
            motorBackArticulator.setPower(MOTOR_POWER);
        }

        if (gamepad1.right_trigger > 0.25) {
            motorBackArticulator.setPower(Motor_Power_Reverse);
        }
    }

}
