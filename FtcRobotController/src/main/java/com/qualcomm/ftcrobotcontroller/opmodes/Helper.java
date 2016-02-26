package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by abedi on 2/26/2016.
 */
public class Helper extends OpMode {
    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;


    public DcMotor motorLeft;
    public DcMotor motorRight;

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("right_motor");
        motorLeft = hardwareMap.dcMotor.get("left_motor");
    }
    @Override
    public void start() {
    }

    @Override
    public  void loop() {
    }

    public  void forward (){
        motorRight.setPower(MOTOR_POWER);
        motorLeft.setPower(Motor_Power_Reverse);
    }
    public void back (){
        motorRight.setPower(Motor_Power_Reverse);
        motorLeft.setPower(MOTOR_POWER);
    }
    public void turnLeft (){
        motorRight.setPower(Motor_Power_Reverse);
        motorLeft.setPower(Motor_Power_Reverse);

    }
    public void turnRight () {
        motorRight.setPower(MOTOR_POWER);
        motorLeft.setPower(MOTOR_POWER);

    }
    public void stopMoving () {
        motorRight.setPower(0.0);
        motorLeft.setPower(0.0);

    }
}

