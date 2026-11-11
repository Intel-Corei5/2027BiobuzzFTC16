package org.firstinspires.ftc.teamcode.pedro.OpModes;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.pedro.subsystem.Intake;
import org.firstinspires.ftc.teamcode.pedro.subsystem.Shooter;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;
@TeleOp(name = "Example TeleOp")        // Run your subsystem's periodic updates if it uses PID/state machines
public class ExampleTeleOp extends OpMode {

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
        DrivePowers powers = ManualDrive.fieldCentric(
                gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()
        );
        follower.manual(powers);
        // relocalise button
        if (gamepad1.dpad_down) {
            Pose cornerPose = new Pose(10.5, 10.5, Math.toRadians(90));
            // On the fly Pose creation, we don't recommend this for Autonomous. Only accepts radians for heading
            follower.setPose(cornerPose); // overrides our pose
        }

        follower.update();
        Pose robotPose = follower.pose(); // returns a Pose object
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
        // Math.toDegrees() is a built-in java method


        Shooter.revNecter(gamepad1);
        Shooter.revPollen(gamepad1);



    }
}
