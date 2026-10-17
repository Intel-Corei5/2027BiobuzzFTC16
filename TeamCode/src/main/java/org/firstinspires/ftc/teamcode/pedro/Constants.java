package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeft");
        c.frontRightName.set("frontRight");
        c.backLeftName.set("backLeft");
        c.backRightName.set("backRight");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(3.8443398663378137);
        c.yPodOffset.set(-0.33674987282339985);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.3255463133930188);
                Controller secondaryTranslationalForward = Controller.proportional(0.12028066404101928);
                Controller primaryTranslationalLateral = Controller.proportional(1.5593306922229713);
                Controller secondaryTranslationalLateral = Controller.proportional(0.5761310246929164);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.011823275003874341));
                c.brake.set(Controller.proportionalFeedforward(0.01004978375329319));

                c.headingFeedback.set(Controller.proportional(5.365017414051003));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04719545185437379, 0.019587365652577272));

                c.linearBrakeCoefficients.set(Matrix.diag(-0.006110845865452476, 0.07948518702452295));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.003923627556257128, 0.0019090375691271277));

                c.maxAchievableForwardVelocity.set(73.85663378651644);
                c.maxAchievableStrafeVelocity.set(59.555957620329636);
                c.naturalForwardDeceleration.set(34.12323405231013);
                c.naturalStrafeDeceleration.set(34.314357555418226);
            }
    );
}