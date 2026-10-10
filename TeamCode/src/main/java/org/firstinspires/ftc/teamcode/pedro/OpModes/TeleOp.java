package org.firstinspires.ftc.teamcode.pedro.OpModes;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.pedro.Constants;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;
public class TeleOp {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }
    DrivePowers powers = ManualDrive.fieldCentric(
    -gamepad1.left_stick_y,
    gamepad1.left_stick_x,
    gamepad1.right_stick_x,
    follower.pose().heading()
);
follower.manual(powers);
followr.update();
}
@Override
public.void loop() {
    DrivePowers powers = ManualDrive.fieldCentric(
            -gamepad1.left_stick_y,
            gamepad1.left_stick_x,
            gamepad1.right_stick_x
            follower.pose().heading()
    );

    follower.manual(powers);
    follower.update();
}