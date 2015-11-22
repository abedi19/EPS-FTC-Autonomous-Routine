package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/20/2015.
 */
public class RobotDrive extends OpMode {
    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;
//    final static double Dropper_MIN_RANGE  = 0.20;
//    final static double Dropper_MAX_RANGE  = 0.90;
//    double dropperPosition = 0.0;
//    double dropperDelta = 0.1;

    // final static double HOLD_IR_SIGNAL_STRENGTH = 0.20; // Higher values will cause the robot to follow closer


    DcMotor motorBackArticulator;
    DcMotor motorFrontArticulator;

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;

//    Servo servoDropper;
//    Servo servoLeftZipline;
//    Servo servoRightZipline;
    @Override
    public void init() {
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
        motorFrontArticulator = hardwareMap.dcMotor.get("front_legs");
        motorBackArticulator = hardwareMap.dcMotor.get("back_legs");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left_drive");
        motorFrontRight = hardwareMap.dcMotor.get("front_right_drive");
        motorBackLeft = hardwareMap.dcMotor.get("back_left_drive");
        motorBackRight = hardwareMap.dcMotor.get("back_right_drive");
//        servoDropper = hardwareMap.servo.get("dropper");
//        servoRightZipline = hardwareMap.servo.get("right_zipline");
//        servoLeftZipline = hardwareMap.servo.get("left_zipline");
//        servoLeftZipline.setPosition(0);
//        servoRightZipline.setPosition(0);
//        servoDropper.setPosition(0);
//        dropperPosition = Range.clip(dropperPosition, 0, 1);

    }

    @Override
    public void start() {
//    servoDropper.setPosition(0);
    }

    @Override
    public void loop() {
// always make the Back Right motor go backwards as it is wired with the wrong polarity
        if (gamepad1.dpad_down) {
            motorFrontLeft.setPower(MOTOR_POWER);
            motorFrontRight.setPower(MOTOR_POWER);
            motorBackLeft.setPower(MOTOR_POWER);
            motorBackRight.setPower(Motor_Power_Reverse);
        } else if (gamepad1.dpad_up) {
            motorFrontLeft.setPower(Motor_Power_Reverse);
            motorFrontRight.setPower(Motor_Power_Reverse);
            motorBackLeft.setPower(Motor_Power_Reverse);
            motorBackRight.setPower(MOTOR_POWER);
        } else if (gamepad1.dpad_left) {
            motorFrontLeft.setPower(Motor_Power_Reverse);
            motorBackLeft.setPower(Motor_Power_Reverse);
            motorBackRight.setPower(Motor_Power_Reverse);
            motorFrontRight.setPower(MOTOR_POWER);
        } else if (gamepad1.dpad_right) {
            motorFrontLeft.setPower(MOTOR_POWER);
            motorFrontRight.setPower(Motor_Power_Reverse);
            motorBackLeft.setPower(MOTOR_POWER);
            motorBackRight.setPower(MOTOR_POWER);
        } else {
            motorFrontLeft.setPower(0.0);
            motorFrontRight.setPower(0.0);
            motorBackLeft.setPower(0.0);
            motorBackRight.setPower(0.0);
        }

        if (gamepad1.left_bumper) {
            motorFrontArticulator.setPower(MOTOR_POWER);
        } else if (gamepad1.left_trigger> 0.25 ) {
            motorFrontArticulator.setPower(Motor_Power_Reverse);
        } else  {
            motorFrontArticulator.setPower(0.0);
        }
            // back treads
        if (gamepad1.right_bumper) {
            motorBackArticulator.setPower(MOTOR_POWER);
        } else if (gamepad1.right_trigger > 0.25) {
            motorBackArticulator.setPower(Motor_Power_Reverse);
        } else {
            motorBackArticulator.setPower(0.0);
        }

//        dropperPosition = Range.clip(dropperPosition, -1, 1);
//
//        // moves servo back and front
//        if (gamepad1.y)  {
//            // move servo back to 90/ -90
//            dropperPosition += dropperDelta;
//            if (dropperPosition >= 1) {
//                dropperPosition = 0;
//            }
//            servoDropper.setPosition(dropperPosition);
//        } else if (gamepad1.a) {
//            // move servo back to 90
//            dropperPosition -= dropperDelta;
//            if (dropperPosition <= -1) {
//                dropperPosition = 0;
//            }
//            servoDropper.setPosition(dropperPosition);
//        }
//        if (gamepad1.x && servoLeftZipline.getPosition() >45) {
//            servoLeftZipline.setPosition(90);
//        } else if (gamepad1.x && servoLeftZipline.getPosition() <= 145) {
//            servoLeftZipline.setPosition(0);
//        }
//
//        if (gamepad1.b && servoRightZipline.getPosition() >45) {
//            servoRightZipline.setPosition(90);
//        } else if (gamepad1.x && servoRightZipline.getPosition() <= 145) {
//            servoRightZipline.setPosition(180);
//        }

    }

}
