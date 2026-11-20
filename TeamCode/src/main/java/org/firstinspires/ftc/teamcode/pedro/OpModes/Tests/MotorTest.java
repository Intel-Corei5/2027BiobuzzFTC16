// Jack Slayer, To test the shooter motor on BioBuzz Robot.

package org.firstinspires.ftc.teamcode.pedro.OpModes.Tests;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MotorTest", group = "Test")
public class MotorTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        //Servo Servo = hardwareMap.get(Servo.class, "Servo");
        DcMotorEx test = hardwareMap.get(DcMotorEx.class, "pollenShooter");
        //DcMotorEx test2 = hardwareMap.get(DcMotorEx.class, "test2");
        test.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // test2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        test.setDirection(DcMotorSimple.Direction.FORWARD);
        //test2.setDirection(DcMotorSimple.Direction.REVERSE);
        test.setVelocityPIDFCoefficients(1.29003937,0.129003937,0,12.900393701);


        waitForStart();

        while(opModeIsActive()) {
            double postition;
            double velocity = 1500;


            test.setVelocity(1500);

            telemetry.addData("wut", test.getVelocity());
            telemetry.update();
        }

    }
}
