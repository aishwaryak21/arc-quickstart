package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.commands.teleOp.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.teleOp.TestMotorCommand;
import org.firstinspires.ftc.teamcode.subsystems.TeleOp.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TeleOp.TestMotorSubsystem;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends CommandOpMode {

    //Motor
    private Motor fL, fR, bL, bR;
    private Motor testMotor;

    //Subsystems
    private DriveSubsystem driveS;
    private TestMotorSubsystem testMotorSubsystem;


    //Commands
    private DriveCommand driveC;
    private TestMotorCommand testMotorCommand;

    //Extra
    private GamepadEx gPad1;

    //Constants
    private final double SLOW_MULT = 0.5;
    private final double MOTOR_SPEED = 0.75;

    @Override
    public void initialize() {
        //INITIALIZING MOTORS
        fL = new Motor(hardwareMap, "frontLeft");
        fR = new Motor(hardwareMap, "frontRight");
        bL = new Motor(hardwareMap, "backLeft");
        bR = new Motor(hardwareMap, "backRight");
        testMotor = new Motor(hardwareMap, "testMotor");

        //INITIALIZING EXTRAS
        gPad1 = new GamepadEx(gamepad1);



        //MOTOR SETTINGS
        fL.motor.setDirection(DcMotor.Direction.REVERSE);
        fR.motor.setDirection(FORWARD);
        bL.motor.setDirection(DcMotor.Direction.REVERSE);
        bR.motor.setDirection(FORWARD);
        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //INITIALIZING COMMANDS AND SUBSYSTEMS
        driveS = new DriveSubsystem(fL, fR, bL, bR);
        driveC = new DriveCommand(driveS, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX);
        testMotorSubsystem = new TestMotorSubsystem(testMotor);
        testMotorCommand = new TestMotorCommand(testMotorSubsystem, MOTOR_SPEED);
        

        gPad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new DriveCommand(driveS, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX, SLOW_MULT));

        gPad1.getGamepadButton(GamepadKeys.Button.X)
                .whenHeld(testMotorCommand);

    }


}

