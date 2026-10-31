package org.firstinspires.ftc.teamcode.pedro.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {
    private DcMotorEx Intake;
    public Intake(HardwareMap hwMap) {
        Intake = hwMap.get(DcMotorEx.class, "Intake");
    }
    public void intake(Gamepad gamepad) {
        if (gamepad.aWasPressed()) {
            Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Intake.setVelocity(1000);
        }else{
            Intake.setVelocity(0);
        }


    }
}

