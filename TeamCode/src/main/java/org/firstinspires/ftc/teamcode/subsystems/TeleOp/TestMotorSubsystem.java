package org.firstinspires.ftc.teamcode.subsystems.TeleOp;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class TestMotorSubsystem extends SubsystemBase {
    private Motor testMotor;

    public TestMotorSubsystem (Motor TM) {
        testMotor = TM;
    }
    public void run(double power) {
        testMotor.set(power);
    }
    public void stop() {
        testMotor.set(0);
    }

}
