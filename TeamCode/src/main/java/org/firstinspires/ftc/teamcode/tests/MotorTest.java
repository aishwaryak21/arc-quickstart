package org.firstinspires.ftc.teamcode.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "motorAuton")
public class MotorTest extends CommandOpMode {
    private Motor m;
    @Override
    public void initialize() {
        m = new Motor(hardwareMap, "TestMotor1");

        schedule(
                new WaitUntilCommand(this::isStarted)
                    .andThen(new InstantCommand(()->m.set(1)))

        );
    }
}
