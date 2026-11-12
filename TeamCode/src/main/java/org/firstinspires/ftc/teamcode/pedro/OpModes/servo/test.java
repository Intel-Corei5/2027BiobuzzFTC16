package org.firstinspires.ftc.teamcode.pedro.OpModes.servo;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "ServoTest", group = "Test")
public class test extends LinearOpMode {

    @Override
    public void runOpMode() {

        Servo necterGate = hardwareMap.get(Servo.class, "necterGate");
        double servoAngle;

        waitForStart();

        while (opModeIsActive()) {
            servoAngle = necterGate.getPosition();
            if (gamepad1.dpad_up){
                servoAngle +=.01;
            }else if(gamepad1.dpad_down){
                servoAngle -=.01;
            }else if(gamepad1.a){
                servoAngle = .49;
            }

            necterGate.setPosition(servoAngle);
            telemetry.addData("ServoAngle", servoAngle);
            telemetry.update();
        }


    }
}
