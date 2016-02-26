package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by abedi on 11/22/2015.
 */
public class AutoPark extends  OpMode{

    // start copy

    final static double MOTOR_POWER = 1; // Higher values will cause the robot to move faster
    final static double Motor_Power_Reverse = -1;

    // final static double HOLD_IR_SIGNAL_STRENGTH = 0.20; // Higher values will cause the robot to follow closer


    HelperOld helper;



    @Override
    public void init () {
//        legacyOne=hardwareMap.legacyModule.get(Legacy_module_2);
//        motorDrive = hardwareMap.dcMotor.g
        helper = new HelperOld();

    } // end copy

    @Override
    public void start () {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               helper.forward();

            }
        },15000) ;


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.stopMoving();
            }
        }, 25000);
    }

    @Override
    public void loop () {



    }

}
