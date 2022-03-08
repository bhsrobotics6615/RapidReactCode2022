package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class DriveTrainSubsystem extends SubsystemBase {

    // Drive control motors
    final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
    final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
    final WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
    final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7

    MecanumDrive drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
 

    public void move(double forwardSpeed, double horizontalSpeed, double rotationRate) { // Move the robot in a
                                                                                         // specified direction
        backRight.setInverted(true);
        backLeft.setInverted(true);

        // horizontal, forward, and rotation speeds are between -1 and 1, where positive
        // is right/forward/clockwise.
        if (forwardSpeed > 0) {

            forwardSpeed = Math.pow(forwardSpeed, 2);

        } else if (forwardSpeed < 0) {

            forwardSpeed = -Math.pow(forwardSpeed, 2);

        }

        if (horizontalSpeed > 0) {

            horizontalSpeed = Math.pow(horizontalSpeed, 2);

        } else if (horizontalSpeed < 0) {

            horizontalSpeed = -Math.pow(horizontalSpeed, 2);

        }

        if (rotationRate > 0) {

            rotationRate = -Math.pow(rotationRate, 2);

        } else if (rotationRate < 0) {

            rotationRate = Math.pow(rotationRate, 2);
            
        }

        drive.driveCartesian(horizontalSpeed, -forwardSpeed, rotationRate);

    }
     
    public void driveDistance(double distance) {

    }

    public void stop() { // Stop motor movement

        drive.driveCartesian(0, 0, 0);
        
    }
}