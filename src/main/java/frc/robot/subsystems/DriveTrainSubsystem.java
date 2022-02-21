package frc.robot.subsystems;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrainSubsystem extends SubsystemBase {

    // public PWMTalonSRX frontLeft, backLeft, frontRight, backRight;
    public MecanumDrive drive;

    public DriveTrainSubsystem(){

        // Drive control motors
        final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
        final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
        final WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
        final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7


        //TODO: Invert the motors on either the left or the right side
        drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    }

   

    
    public void moveAuto(double forwardSpeed, double horizontalSpeed, double rotationRate) { 
        // Move the robot in a specified direction

        // horizontal, forward, and rotation speeds are between -1 and 1, where positive is right/forward/clockwise.
       
        drive.driveCartesian(horizontalSpeed, -forwardSpeed, rotationRate);

    }
    public void move(double forwardSpeed, double horizontalSpeed, double rotationRate) { // Move the robot in a specified direction

        // horizontal, forward, and rotation speeds are between -1 and 1, where positive is right/forward/clockwise.
        forwardSpeed = Math.pow(forwardSpeed, 2);
        horizontalSpeed = Math.pow(horizontalSpeed, 2);
        rotationRate = Math.pow(rotationRate, 2);
        drive.driveCartesian(horizontalSpeed, -forwardSpeed, rotationRate);

    }

    public double smoothOutput(double speedInput) { // Use linear interpolation to smooth changes in acceleration (Autonomous period only)

          double maxSpeedOfMotor = 10; //rpm 
          // Do we know that the maximum speed of the motors is going to be 10rpm??

          double output = speedInput * maxSpeedOfMotor;
          return output;

    }

    public int calculateRPM(String motorType, WPI_TalonSRX motorController){ // Calculate the current motor's RPM given current cartesianDrive settings

        double currentSpeedValue = motorController.get();

        //all motors are type CIM Motor 217-2000
        //use motor curve, voltage, weight translating to resistance, torque created, etc. to calculate rpm

        return (int)(Math.abs(currentSpeedValue) * 5330);

    }

    public void stop() { // Stop motor movement 

        drive.driveCartesian(0, 0, 0);

    }

    // public void Start() {
    //     drive.driveCartesian(startYSpeed, startXSpeed, 0);
    // }
}
