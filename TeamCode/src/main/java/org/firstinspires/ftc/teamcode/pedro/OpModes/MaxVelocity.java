package org.firstinspires.ftc.teamcode.pedro.OpModes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "MaxVelocityTest", group = "Test")

public class MaxVelocity extends LinearOpMode {
    DcMotorEx necterShooter;
    double currentVelocity;
    double MaxVelocity;
    @Override
    public void runOpMode() {
        necterShooter = hardwareMap.get(DcMotorEx.class, "necterShooter");
        necterShooter.setDirection(DcMotorSimple.Direction.REVERSE);
        necterShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        while (opModeIsActive()) {
            necterShooter.setPower(1);
            currentVelocity = necterShooter.getVelocity();
            if (currentVelocity > MaxVelocity) {
                MaxVelocity = currentVelocity;
            }
            telemetry.addData("Current Velocity", currentVelocity);
            telemetry.addData("Maximum Velcocity", MaxVelocity);
            telemetry.update();
        }

    }


}
