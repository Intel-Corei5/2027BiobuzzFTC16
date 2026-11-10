package org.firstinspires.ftc.teamcode.pedro.OpModes.servo;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "MotorTest", group = "Test")
public class test extends LinearOpMode {

    @Override
    public void runOpMode() {
        //Servo Servo = hardwareMap.get(Servo.class, "Servo");
        Servo necterGate = hardwareMap.get(Servo.class, "necterGate");


        waitForStart();

        while (opModeIsActive()) {
            double postition;
            double velocity = 1500;


            if (gamepad1.xWasPressed()) {
                necterGate.setPosition (69);
            }


        }


    }
}
