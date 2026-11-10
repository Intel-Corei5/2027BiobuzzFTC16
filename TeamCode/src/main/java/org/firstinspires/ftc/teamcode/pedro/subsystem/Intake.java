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
        if (gamepad.a) {
            Intake.setDirection(DcMotorSimple.Direction.FORWARD);
            Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Intake.setVelocity(500);
        }else{
            Intake.setVelocity(0);
        }
        if (gamepad.bWasPressed()) {
            Intake.setDirection(DcMotorSimple.Direction.REVERSE);
            Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Intake.setVelocity(-1000);
        }else{
            Intake.setVelocity(0);
        }
        /* if (gamepad.xWasPressed()) {
            Intake.setTargetPosition(45);
            Intake.setMode(servoname idk.RunMode.RUN_USING_ENCODER);
        }else{
            Intake.setTargetPosition(135);
        }  */
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
