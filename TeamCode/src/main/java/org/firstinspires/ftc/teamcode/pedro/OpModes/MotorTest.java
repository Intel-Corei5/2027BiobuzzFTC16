@TeleOp

package org.firstinspires.ftc.teamcode.pedro.OpModes;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


public class MotorTest {
    private DcMotor frontLeftMotor;

    @Override
    public void runOpMode() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");

        waitForStart();

        while(linearOpMode.opModeIsActive()) {
            
        }

    }
}
