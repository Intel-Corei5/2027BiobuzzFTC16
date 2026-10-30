package org.firstinspires.ftc.teamcode.pedro.subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Intake {

    DcMotorEx Intake = hardwareMap.get(DcMotorEx.class, "Intake");
    public void intake() {
        Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Intake.setVelocity(1000);
    }

}
