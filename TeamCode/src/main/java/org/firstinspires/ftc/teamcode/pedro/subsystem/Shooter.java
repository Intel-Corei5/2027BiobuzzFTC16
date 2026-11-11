package org.firstinspires.ftc.teamcode.pedro.subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {

     private Servo NecterServo;
     private Servo PollenServo;
     private DcMotorEx NecterMotor;
     private DcMotorEx PollenMotor;

     private double currentVelocity;


    public Shooter(HardwareMap hwMap){
         NecterMotor = hwMap.get(DcMotorEx.class, "necterShooter");
         PollenMotor = hwMap.get(DcMotorEx.class, "pollenShooter");
         PIDFCoefficients pidfpollenCoeffeciants = new PIDFCoefficients(1.29003937,0.129003937,0,12.900393701);
         PIDFCoefficients pidfNecterCoeffeciants = new PIDFCoefficients(1.33199187, 0.133199187, 0, 13.319918699);
         PollenMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfpollenCoeffeciants);
         NecterMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfNecterCoeffeciants);

    }


    public void shootOneNecter(){
        if (gamepad1.aWasPressed()) {
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            //NecterMotor.setPIDFCoefficients();
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
        }
    }
    public void shootOnePollen(){
        if (gamepad1.aWasPressed()) {
            PollenServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            //PollenMotor.setPIDFCoefficients();
            PollenServo.setPosition(0);
        }
    }
    public void rapidNecter(){
        if (gamepad1.aWasPressed()) {
            NecterServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            //NecterMotor.setPIDFCoefficients();
        }
    } public void rapidPollen(){
        if (gamepad1.aWasPressed()) {
            PollenServo.setPosition(0); // TESTING REQUIRED FOR POSITION OF MOTOR
            //PollenMotor.setPIDFCoefficients();
        }
    }
    public void revPollen(Gamepad gamepad) {
         currentVelocity = PollenMotor.getVelocity();
         if (gamepad.right_trigger_pressed) {
             PollenMotor.setVelocity(1650);
         }else{
             PollenMotor.setVelocity(0);
         }

    }
    public void revNecter(Gamepad gamepad) {
        currentVelocity = PollenMotor.getVelocity();
        if (gamepad.left_trigger_pressed) {
            NecterMotor.setVelocity(1650);
        }else{
            NecterMotor.setVelocity(0);
        }

    }

}

