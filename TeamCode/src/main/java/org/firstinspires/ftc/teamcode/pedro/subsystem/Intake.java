package org.firstinspires.ftc.teamcode.pedro.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotorEx Intake;
    private Servo intakeArmRight;
    private Servo intakeArmLeft;
    private double armAngle = 0;
    public Intake(HardwareMap hwMap) {
        Intake = hwMap.get(DcMotorEx.class, "intake");
        intakeArmRight = hwMap.get(Servo.class,"intakeArmRight");
        intakeArmLeft = hwMap.get(Servo.class, "intakeArmLeft");
    }
    public void intake(Gamepad gamepad) {
        if (gamepad.a){
            Intake.setVelocity(100);
        }else{
            Intake.setVelocity(0);
        }
    }
    public void purge(Gamepad gamepad){
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);
        if (gamepad.b){
            Intake.setVelocity(100);
        }else{
            Intake.setVelocity(0);
        }
    }
    public void intakeArmDown(Gamepad gamepad) {
        if (gamepad.b){

            intakeArmRight.setPosition(100);
            intakeArmLeft.setPosition(100);
        }else{

            intakeArmRight.setPosition(armAngle);
            intakeArmLeft.setPosition(armAngle);
        }

    }
}


