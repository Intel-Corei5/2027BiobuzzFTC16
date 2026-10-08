// Jack Slayer, To test the shooter motor on BioBuzz Robot.

package org.firstinspires.ftc.teamcode.pedro.OpModes;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;


public class MotorTest {


    public void runOpMode() {
        DcMotorEx frontLeftMotor = hardwareMap.get(DcMotorEx.class, "frontLeftMotor");
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        linearOpMode.waitForStart();

        while(linearOpMode.opModeIsActive()) {
            double power = 0;
            double velocity = 1120;
            double RPM = frontLeftMotor.getVelocity() * 60;

            if (linearOpMode.gamepad1.xWasPressed()) {
                power += 0.1;
            } else if (linearOpMode.gamepad2.bWasPressed()) {
                power -= 0.1;
            }
            frontLeftMotor.setVelocity(velocity);

            telemetry.addData("RPM", RPM);
            telemetry.update();
        }

    }
}
