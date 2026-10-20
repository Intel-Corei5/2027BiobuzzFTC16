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
        DcMotorEx test = hardwareMap.get(DcMotorEx.class, "test");
        DcMotorEx test2 = hardwareMap.get(DcMotorEx.class, "test2");
        test.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        test.setDirection(DcMotorSimple.Direction.FORWARD);
        test2.setDirection(DcMotorSimple.Direction.FORWARD);
        test2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        while(opModeIsActive()) {
            double power = 0;
            double velocity = 1500;
            double RPM = (test.getVelocity()/ 28) * 60 ;
            double currentVelcity = test.getVelocity();


            test.setVelocity(velocity);
            test2.setVelocity(velocity);


            telemetry.addData("RPM", currentVelcity);
            telemetry.update();
        }

    }
}
