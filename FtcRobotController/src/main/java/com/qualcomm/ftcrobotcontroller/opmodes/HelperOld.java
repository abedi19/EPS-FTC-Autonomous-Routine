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
public class HelperOld extends OpMode {
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

    public DcMotor motorBackArticulator;
    public DcMotor motorFrontArticulator;

    public DcMotor motorFrontLeft;
    public DcMotor motorFrontRight;
    public DcMotor motorBackLeft;
    public DcMotor motorBackRight;

    public Servo servoDropper;
    public Servo servoLeftZipline;
    public Servo servoRightZipline;

    public HelperOld() {
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
    public void init() {
    }
    @Override
    public void start() {
    }

    @Override
    public  void loop() {
    }

    public  void forward (){
        motorFrontLeft.setPower(MOTOR_POWER);
        motorFrontRight.setPower(MOTOR_POWER);
        motorBackLeft.setPower(MOTOR_POWER);
        motorBackRight.setPower(Motor_Power_Reverse);
    }
    public void back (){
        motorFrontLeft.setPower(Motor_Power_Reverse);
        motorFrontRight.setPower(Motor_Power_Reverse);
        motorBackLeft.setPower(Motor_Power_Reverse);
        motorBackRight.setPower(MOTOR_POWER);
    }
    public void turnLeft (){
        motorFrontLeft.setPower(Motor_Power_Reverse);
        motorBackLeft.setPower(Motor_Power_Reverse);
        motorBackRight.setPower(Motor_Power_Reverse);
        motorFrontRight.setPower(MOTOR_POWER);
    }
    public void turnRight () {
        motorFrontLeft.setPower(MOTOR_POWER);
        motorFrontRight.setPower(Motor_Power_Reverse);
        motorBackLeft.setPower(MOTOR_POWER);
        motorBackRight.setPower(MOTOR_POWER);
    }
    public void stopMoving () {
        motorBackLeft.setPower(0.0);
        motorBackRight.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorFrontLeft.setPower(0.0);
        motorBackArticulator.setPower(0.0);
        motorFrontArticulator.setPower(0.0);

    }
}