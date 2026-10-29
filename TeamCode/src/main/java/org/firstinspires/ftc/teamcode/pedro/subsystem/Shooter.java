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


    public void shootOneNecter(){
        if (gamepad1.aWasPressed()) {
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            NecterMotor.setPIDFCoefficients();
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
        }
    }
    public void shootOnePollen(){
        if (gamepad1.aWasPressed()) {
            PollenServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            PollenMotor.setPIDFCoefficients();
            PollenServo.setPosition(0);
        }
    }
    public void rapidNecter(){
        if (gamepad1.aWasPressed()) {
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            NecterMotor.setPIDFCoefficients();
        }
    } public void rapidPollen(){
        if (gamepad1.aWasPressed()) {
            PollenServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            PollenMotor.setPIDFCoefficients();
        }
    }
}

