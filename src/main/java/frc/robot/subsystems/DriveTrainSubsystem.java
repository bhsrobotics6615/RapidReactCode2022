package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.commands.DriveTrainCommand;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
// import frc.robot.Robot;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrainSubsystem extends SubsystemBase{

    // public PWMTalonSRX frontLeft, backLeft, frontRight, backRight;
    public MecanumDrive drive;

    public DriveTrainSubsystem(){

        // Drive control motors
        final PWMTalonSRX frontRight = new PWMTalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 1
        final PWMTalonSRX backRight = new PWMTalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 2
        final PWMTalonSRX backLeft = new PWMTalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 3
        final PWMTalonSRX frontLeft = new PWMTalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 4

        drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    }

    public void Move(double forwardSpeed, double horizontalSpeed, double rotationRate) { // Move the robot in a specified direction
        // horizontal, forward, and rotation speeds are between -1 and 1, where positive is right/forward/clockwise.
        forwardSpeed = Math.pow(forwardSpeed, 2);
        horizontalSpeed = Math.pow(horizontalSpeed, 2);
        rotationRate = Math.pow(rotationRate, 2);
        drive.driveCartesian(horizontalSpeed, -forwardSpeed, rotationRate);
    }

    public double SmoothOutput(double speedInput) { // Use linear interpolation to smooth changes in acceleration (Autonomous period only)
          double maxSpeedOfMotor = 10; //rpm
          double output = speedInput * maxSpeedOfMotor;
          return output;
    }

    public int CalculateRPM(String motorType, PWMTalonSRX motorController){ // Calculate the current motor's RPM given current cartesianDrive settings
        double currentSpeedValue = motorController.get();

        //all motors are type CIM Motor 217-2000
        //TODO: use motor curve, voltage, weight translating to resistance, torque created, etc. to calculate rpm

        return (int)(Math.abs(currentSpeedValue) * 5330);
    }

    public void Stop() { // Stop motor movement 
        drive.driveCartesian(0, 0, 0);
    }

    // public void Start() {
    //     drive.driveCartesian(startYSpeed, startXSpeed, 0);
    // }
}
