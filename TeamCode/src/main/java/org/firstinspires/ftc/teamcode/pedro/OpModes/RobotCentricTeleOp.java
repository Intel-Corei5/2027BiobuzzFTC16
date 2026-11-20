package org.firstinspires.ftc.teamcode.pedro.OpModes;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.pedro.subsystem.Intake;
import org.firstinspires.ftc.teamcode.pedro.subsystem.Shooter;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp(name = "Example TeleOp")
public class RobotCentricTeleOp extends OpMode {

    private Follower follower;
    private Intake Intake;
    private Shooter Shooter;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        Intake =  new Intake(hardwareMap);
        Shooter = new Shooter(hardwareMap);

    }

    @Override
    public void loop() {
        follower.manual(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );

        follower.update();
        Intake.intake(gamepad2);
        Intake.intake(gamepad2);
        Intake.purge(gamepad2);
        Shooter.rapidNecter(gamepad2);
        Shooter.rapidPollen(gamepad2);

    }
}