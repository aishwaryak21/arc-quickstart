package org.firstinspires.ftc.teamcode.subsystems.TeleOp;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubsystem extends SubsystemBase {
    private Motor backLeft, backRight, frontLeft, frontRight;
    private MecanumDrive mecanumDrive;


    public DriveSubsystem(Motor bL, Motor bR, Motor fL, Motor fR) {
        frontLeft = fL;
        frontRight = fR;
        backLeft = bL;
        backRight = bR;
        mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);

    }



    public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveRobotCentric(- strafeSpeed, -forwardSpeed, -turnSpeed, true);
}

}
