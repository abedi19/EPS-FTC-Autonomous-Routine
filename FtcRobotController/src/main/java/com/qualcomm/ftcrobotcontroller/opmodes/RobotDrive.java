package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by abedi on 2/26/2016.
 */
public class RobotDrive extends Helper {
    @Override
    public void init() {
    }
    @Override
    public void start() {
    }

    @Override
    public  void loop() {
        if(gamepad1.dpad_up) {
            forward();
        } else if (gamepad1.dpad_left) {
            turnLeft();
        } else if (gamepad1.dpad_right) {
            turnRight();
        } else if(gamepad1.dpad_down) {
            back();
        } else {
            stopMoving();
        }
    }
}
