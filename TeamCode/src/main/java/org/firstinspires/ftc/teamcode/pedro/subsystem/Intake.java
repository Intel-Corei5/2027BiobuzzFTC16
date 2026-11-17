package org.firstinspires.ftc.teamcode.pedro.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotorEx Intake;
    private Servo intakeArmRight;
    private Servo intakeArmLeft;
    private double armAngle = 0;

    private double IntakeSpeed = 2500;
    public Intake(HardwareMap hwMap) {
        Intake = hwMap.get(DcMotorEx.class, "intake");
        intakeArmRight = hwMap.get(Servo.class,"intakeArmRight");
        intakeArmLeft = hwMap.get(Servo.class, "intakeArmLeft");
        PIDFCoefficients intakePID = new PIDFCoefficients(5.461166667, 0.546116667, 0, 54.611666667);
        Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Intake.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,intakePID);
    }
    public void powerHandling(Gamepad gamepad){
        if (gamepad.dpad_up){

        }

    }
    public void intake(Gamepad gamepad) {
        Intake.setDirection(DcMotorSimple.Direction.FORWARD);
        if (gamepad.a) {
            Intake.setVelocity(IntakeSpeed);
        }else {
            Intake.setVelocity(0);
        }
    }
    public void purge(Gamepad gamepad){
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);
        if (gamepad.b){
            Intake.setVelocity(IntakeSpeed);
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

