package org.firstinspires.ftc.teamcode.pedro.subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {

     Servo NecterServo = hardwareMap.get(Servo.class, "NecterServo");
     Servo PollenServo = hardwareMap.get(Servo.class, "PollenServo");
     DcMotorEx NecterMotor = hardwareMap.get(DcMotorEx.class, "NecterMotor");
     DcMotorEx PollenMotor = hardwareMap.get(DcMotorEx.class, "PollenMotor");


    public void shootOne(){
        if (gamepad1.aWasPressed()) {

        }
    }

}
