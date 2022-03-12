package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import frc.robot.Constants;
// import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;


public class DriveTrainSubsystem extends SubsystemBase {

    public void move(double forwardSpeed, double horizontalSpeed, double rotationRate) { // Move the robot in a specified direction
        
        // horizontal, forward, and rotation speeds are between -1 and 1, where positive
        // is right/forward/clockwise.
//         if (forwardSpeed > 0) {

//             forwardSpeed = Math.pow(forwardSpeed, 2);

//         } else if (forwardSpeed < 0) {

//             forwardSpeed = -Math.pow(forwardSpeed, 2);

//         }

//         if (horizontalSpeed > 0) {

//             horizontalSpeed = Math.pow(horizontalSpeed, 2);

//         } else if (horizontalSpeed < 0) {

//             horizontalSpeed = -Math.pow(horizontalSpeed, 2);

//         }

//         if (rotationRate > 0) {

//             rotationRate = Math.pow(rotationRate, 2);

//         } else if (rotationRate < 0) {

//             rotationRate = -Math.pow(rotationRate, 2);
            
//         }

        Robot.m_robotContainer.drive.driveCartesian(forwardSpeed, horizontalSpeed, rotationRate);

    }
     
    public void driveDistance(double distance) {

    }

    public void stop() { // Stop motor movement

        Robot.m_robotContainer.drive.driveCartesian(0, 0, 0);
        
    }
}
