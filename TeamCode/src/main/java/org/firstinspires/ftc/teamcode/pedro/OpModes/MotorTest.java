// Jack Slayer, To test the shooter motor on BioBuzz Robot.

package org.firstinspires.ftc.teamcode.pedro.OpModes;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;

@TeleOp(name = "MotorTest", group = "Test")
public class MotorTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotorEx frontLeftMotor = hardwareMap.get(DcMotorEx.class, "frontLeftMotor");
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            double power = 0;
            double velocity = 1120;
            double RPM = (frontLeftMotor.getVelocity()/ 28) * 60 ;


            frontLeftMotor.setVelocity(velocity);

            telemetry.addData("RPM", RPM);
            telemetry.update();
        }

    }
}
