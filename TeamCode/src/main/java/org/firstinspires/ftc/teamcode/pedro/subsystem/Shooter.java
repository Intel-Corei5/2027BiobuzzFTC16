package org.firstinspires.ftc.teamcode.pedro.subsystem;

import static android.os.SystemClock.sleep;
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
     private double targetVelocityPollen = 1650;
     private double targetVelocityNecter = 1725;
     private double currentVelocity;


    public Shooter(HardwareMap hwMap){
         NecterMotor = hwMap.get(DcMotorEx.class, "necterShooter");
         PollenMotor = hwMap.get(DcMotorEx.class, "pollenShooter");
         NecterServo = hwMap.get(Servo.class,"necterGate");
         PollenServo = hwMap.get(Servo.class,"pollenGate");
         PIDFCoefficients pidfpollenCoeffeciants = new PIDFCoefficients(1.29003937,0.129003937,0,12.900393701);
         PIDFCoefficients pidfNecterCoeffeciants = new PIDFCoefficients(1.33199187, 0.133199187, 0, 13.319918699);
         PollenMotor.setVelocityPIDFCoefficients(1.29003937,0.129003937,0,12.900393701);
         NecterMotor.setVelocityPIDFCoefficients(1.33199187, 0.133199187, 0, 13.319918699);
         NecterServo.setPosition(necterGateClosed);
         PollenServo.setPosition(pollenGateClosed);
         PollenMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         NecterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }



    public void rapidNecter(Gamepad gamepad){
        NecterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        if (gamepad.right_trigger_pressed) {
            NecterMotor.setVelocity(targetVelocityNecter);

            if (NecterMotor.getVelocity()>=targetVelocityNecter){
                NecterServo.setPosition(necterGateOpened);
            }

        }else{
            NecterServo.setPosition(necterGateClosed);
            NecterMotor.setVelocity(0);
        }
    }
    public void rapidPollen(Gamepad gamepad){
        if (gamepad.left_trigger_pressed) {
            PollenMotor.setVelocity(targetVelocityPollen);

            if (PollenMotor.getVelocity()>=targetVelocityPollen) {
                PollenServo.setPosition(necterGateOpened);
            }
        }else{
            PollenServo.setPosition(necterGateClosed);
            PollenMotor.setVelocity(0);
        }
    }
    public void powerHandling(Gamepad gamepad){
        if (gamepad.left_bumper){

        }else-if{

        }

    }

    public void necterGateClosed(){
        NecterServo.setPosition(necterGateClosed);
    }

}

