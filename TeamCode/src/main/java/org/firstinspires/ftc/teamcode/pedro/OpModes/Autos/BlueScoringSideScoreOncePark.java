package org.firstinspires.ftc.teamcode.pedro.OpModes.Autos;

import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.*;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.Constants;

@Autonomous(name = "BlueScoringSideScoreOncePark", group = "Autonomous")
public class BlueScoringSideScoreOncePark extends LinearOpMode {

    private Follower follower;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(83.7127, 134.4507, 270);
    private final Pose toScore = poseFactory.of(84.2633, 109.9617, 270);
    private final Pose toParkStart = poseFactory.of(84.2633, 109.9617, 270);
    private final Pose toPark = poseFactory.of(131.9266, 44.555, 180);
    private final Pose toParkControl1 = poseFactory.of(124.2618, 121.534, 0);

    // Autonomous routine
    public Command autoRoutine() {
        return sequential(
                follow(follower, toScore()),
                follow(follower, toPark())
        );
    }

    @Override
    public void runOpMode() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);
        follower.update();

        waitForStart();
        schedule(autoRoutine());

        while (opModeIsActive()) {
            follower.update();
            Scheduler.execute();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }

    public Path toScore() {
        return Paths.line(start, toScore).linear(start, toScore);
    }

    public Path toPark() {
        return Paths.curve(toParkStart, toParkControl1, toPark).linear(toParkStart, toPark);
    }
}

