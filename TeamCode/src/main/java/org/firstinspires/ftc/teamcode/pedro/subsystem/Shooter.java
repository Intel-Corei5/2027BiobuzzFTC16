package org.firstinspires.ftc.teamcode.pedro.subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {

     private Servo NecterServo;
     private Servo PollenServo;
     private DcMotorEx NecterMotor;
     private DcMotorEx PollenMotor;
     private double necterGateClosed = 1;
     private double necterGateOpened = 0;
     private double pollenGateClosed = 1;
     private double pollenGateOpened = 0;

     private double currentVelocity;


    public Shooter(HardwareMap hwMap){
         NecterMotor = hwMap.get(DcMotorEx.class, "necterShooter");
         PollenMotor = hwMap.get(DcMotorEx.class, "pollenShooter");
         NecterServo = hwMap.get(Servo.class,"necterGate");
         PollenServo = hwMap.get(Servo.class,"pollenGate");
         PIDFCoefficients pidfpollenCoeffeciants = new PIDFCoefficients(1.29003937,0.129003937,0,12.900393701);
         PIDFCoefficients pidfNecterCoeffeciants = new PIDFCoefficients(1.33199187, 0.133199187, 0, 13.319918699);
         PollenMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfpollenCoeffeciants);
         NecterMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfNecterCoeffeciants);
         NecterServo.setPosition(necterGateClosed);
         PollenServo.setPosition(pollenGateClosed);

    }



    public void rapidNecter(Gamepad gamepad){
        if (gamepad.right_trigger_pressed) {
            NecterServo.setPosition(necterGateOpened);
            NecterMotor.setVelocity(1650);
        }else{
            NecterServo.setPosition(necterGateClosed);
            NecterMotor.setVelocity(0);
        }
    }
    public void rapidPollen(Gamepad gamepad){
        if (gamepad.right_trigger_pressed) {
            NecterServo.setPosition(necterGateOpened);
            NecterMotor.setVelocity(1650);
        }else{
            NecterServo.setPosition(necterGateClosed);
            NecterMotor.setVelocity(0);
        }
    }

    public void necterGateClosed(){
        NecterServo.setPosition(necterGateClosed);
    }

}

