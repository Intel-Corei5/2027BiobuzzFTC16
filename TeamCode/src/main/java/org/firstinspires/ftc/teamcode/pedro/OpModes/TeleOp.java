package org.firstinspires.ftc.teamcode.pedro.OpModes;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;

public class TeleOp {
}
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;
DrivePowers powers = ManualDrive.fieldCentric(
        -gamepad1.left_stick_y,
        gamepad1.left_stick_x,
        gamepad1.right_stick_x,
        follower.pose().heading()
);
follower.manual(powers);
follower.update();
@Override
public void loop() {
    DrivePowers powers = ManualDrive.fieldCentric(
            -gamepad1.left_stick_y,
            gamepad1.left_stick_x,
            gamepad1.right_stick_x,
            follower.pose().heading()
    );

    follower.manual(powers);
    follower.update();
}
