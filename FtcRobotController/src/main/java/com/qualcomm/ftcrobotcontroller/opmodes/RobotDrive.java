package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.Timer;
import java.util.TimerTask;
// hello
// left zipline needs some work
// right zipline works
//syringe works
// zipline servos shake alot when they are being moved
// maybe bad/ spoiled?

/**
 * Created by abedi on 11/20/2015.
 */
public class RobotDrive extends OpMode {
    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;
    final static double Dropper_MIN_RANGE  = 0.20;
    final static double Dropper_MAX_RANGE  = 0.90;
    double dropperPosition = 0.0;
    double dropperDelta = 0.1;
    int leftPressed = 0;
    int rightPressed = 0;
    double leftPosition;
    double rightPosition;

    DcMotor motorBackArticulator;
    DcMotor motorFrontArticulator;

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;

    Servo servoDropper;
    Servo servoLeftZipline;
    Servo servoRightZipline;

    Helper helper = new Helper();
    DcMotor[] motors = {motorBackArticulator, motorFrontArticulator, motorBackLeft, motorBackRight, motorFrontLeft, motorFrontRight};

    @Override
    public void init() {
        // setting specific motors to specific things in the hardware map
        motorFrontArticulator = hardwareMap.dcMotor.get("front_up");
        motorBackArticulator = hardwareMap.dcMotor.get("back_up");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left_drive");
        motorFrontRight = hardwareMap.dcMotor.get("front_right_drive");
        motorBackLeft = hardwareMap.dcMotor.get("back_left_drive");
        motorBackRight = hardwareMap.dcMotor.get("back_right_drive");
        servoDropper = hardwareMap.servo.get("dropper");
        servoDropper.setPosition(0);
        servoLeftZipline = hardwareMap.servo.get("leftzip");
        servoLeftZipline.setPosition(1);
        servoRightZipline = hardwareMap.servo.get("rightzip");
        servoRightZipline.setPosition(0.5);

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        // tank style steering
// always make the Back Right motor go backwards as it is wired with the wrong polarity
        if (gamepad1.dpad_down) {
            helper.forward(motors);
        } else if (gamepad1.dpad_up) {
           helper.back(motors);
        } else if (gamepad1.dpad_left) {
            helper.turnLeft(motors);
        } else if (gamepad1.dpad_right) {
            helper.turnRight(motors);
        } else {
            helper.stopMoving(motors);
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

        dropperPosition = Range.clip(dropperPosition, 0.0, 1.0);
        if(gamepad1.y) {
            // moves servo to position 0.5 aka 90 degrees
            dropperPosition= 1;
            servoDropper.setPosition(dropperPosition);
        } else if (gamepad1.a) {
            dropperPosition= 0;
            servoDropper.setPosition(dropperPosition);
        }

//        // moves servo back and front
//        if (gamepad1.y)  {
//            // move servo back to 90/ -90
//            dropperPosition += dropperDelta;
//            if (dropperPosition >= 1) {
//                dropperPosition = 1;
//            }
//            servoDropper.setPosition(dropperPosition);
//        } else if (gamepad1.a) {
//            // move servo back to 90
//            dropperPosition -= dropperDelta;
//            if (dropperPosition <= 0) {
//                dropperPosition = 0;
//            }
//            servoDropper.setPosition(dropperPosition);
//        }
        // to set servo you do servo"name".setPosition("what ever variable you set for the clip" ) in the example below it is servoLeftZipline.setPostion(leftPosition)
        leftPosition = Range.clip(leftPosition, 0.0, 1.0);
        if (gamepad1.x && leftPressed%2 == 0) {
            leftPosition = 0.5;
            leftPressed = 1 + leftPressed;
            servoLeftZipline.setPosition(leftPosition);
        } else if (gamepad1.x && leftPressed%2 != 0) {
            leftPosition = 1.0;
            leftPressed = 1 + leftPressed;
            servoLeftZipline.setPosition(leftPosition);
        }
        rightPosition = Range.clip(rightPosition, 0.0, 1.0);

        if (gamepad1.b && rightPressed%2 == 0) {
            rightPosition = 0.5;
            rightPressed = 1 + rightPressed;
            servoRightZipline.setPosition(rightPosition);
        } else if (gamepad1.b && rightPressed%2 != 0) {
            rightPosition = 0.0;
            rightPressed = 1 + rightPressed;
            servoRightZipline.setPosition(rightPosition);

        }

    }


}
