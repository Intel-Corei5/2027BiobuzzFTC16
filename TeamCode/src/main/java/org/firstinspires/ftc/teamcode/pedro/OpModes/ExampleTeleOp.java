package org.firstinspires.ftc.teamcode.pedro.OpModes;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.pedro.subsystem.Intake;
@TeleOp(name = "Example TeleOp")        // Run your subsystem's periodic updates if it uses PID/state machines
public class ExampleTeleOp extends OpMode {

    private Follower follower;
    private Intake Intake;
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        Intake = new Intake(hardwareMap);
    }

    @Override
    public void loop() {

        follower.manual(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );
        follower.update();

        Intake.intake(gamepad1);
    }
}
