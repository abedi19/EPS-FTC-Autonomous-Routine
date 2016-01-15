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

    Helper helper;



    @Override
    public void init() {
        helper = new Helper();

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        // tank style steering
// always make the Back Right motor go backwards as it is wired with the wrong polarity
        if (gamepad1.dpad_down) {
            helper.forward();
        } else if (gamepad1.dpad_up) {
           helper.back();
        } else if (gamepad1.dpad_left) {
            helper.turnLeft();
        } else if (gamepad1.dpad_right) {
            helper.turnRight();
        } else {
            helper.stopMoving();
        }

        if (gamepad1.left_bumper) {
            helper.motorFrontArticulator.setPower(MOTOR_POWER);
        } else if (gamepad1.left_trigger> 0.25 ) {
            helper.motorFrontArticulator.setPower(Motor_Power_Reverse);
        } else  {
            helper.motorFrontArticulator.setPower(0.0);
        }
             // back treads
        if (gamepad1.right_bumper) {
            helper.motorBackArticulator.setPower(MOTOR_POWER);
        } else if (gamepad1.right_trigger > 0.25) {
            helper.motorBackArticulator.setPower(Motor_Power_Reverse);
        } else {
            helper.motorBackArticulator.setPower(0.0);
        }

        dropperPosition = Range.clip(dropperPosition, 0.0, 1.0);
        if(gamepad1.y) {
            // moves servo to position 0.5 aka 90 degrees
            dropperPosition= 1;
            helper.servoDropper.setPosition(dropperPosition);
        } else if (gamepad1.a) {
            dropperPosition= 0;
            helper.servoDropper.setPosition(dropperPosition);
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
            helper.servoLeftZipline.setPosition(leftPosition);
        } else if (gamepad1.x && leftPressed%2 != 0) {
            leftPosition = 1.0;
            leftPressed = 1 + leftPressed;
            helper.servoLeftZipline.setPosition(leftPosition);
        }
        rightPosition = Range.clip(rightPosition, 0.0, 1.0);

        if (gamepad1.b && rightPressed%2 == 0) {
            rightPosition = 0.5;
            rightPressed = 1 + rightPressed;
            helper.servoRightZipline.setPosition(rightPosition);
        } else if (gamepad1.b && rightPressed%2 != 0) {
            rightPosition = 0.0;
            rightPressed = 1 + rightPressed;
            helper.servoRightZipline.setPosition(rightPosition);

        }

    }


}
