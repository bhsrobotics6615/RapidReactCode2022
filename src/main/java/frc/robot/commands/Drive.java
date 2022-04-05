package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Drive extends CommandBase {
    private final DriveTrainSubsystem drive_subsystem;
    double forwardSpeed;
    double horizontalSpeed;
    double rotationRate;
    
    public Drive(DriveTrainSubsystem subsystem) {
        drive_subsystem  = subsystem;

        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
        double leftY = -Robot.m_robotContainer.DriveController.getLeftY(); // This is negative because the controllers joystick Y-Axis is flipped (Up is -1)
        double leftX = Robot.m_robotContainer.DriveController.getLeftX();
        double rightX = Robot.m_robotContainer.DriveController.getRightX();


        if (leftY > 0) {
            forwardSpeed = Math.pow(leftY, 2);
        } else if (leftY < 0) {
            forwardSpeed = -Math.pow(leftY, 2);
        }

        if (leftX > 0) {
            horizontalSpeed = Math.pow(leftX, 2);
        } else if (leftX < 0) {
            horizontalSpeed = -Math.pow(leftX, 2);
        }

        if (rightX > 0) {
            rotationRate = Math.pow(rightX, 2);
        } else if (rightX < 0) {
            rotationRate = -Math.pow(rightX, 2);
        }
        
        drive_subsystem.move(
            forwardSpeed,
            horizontalSpeed,
            rotationRate
        );

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        drive_subsystem.stop();
        
    }

}
