package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Drive extends CommandBase {
    private final DriveTrainSubsystem drive_subsystem;
    
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
     
        drive_subsystem.move(
            Robot.m_robotContainer.DriveController.getLeftY(), 
            Robot.m_robotContainer.DriveController.getLeftX(),
            Robot.m_robotContainer.DriveController.getRightX()
        );

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        drive_subsystem.stop();
        
    }

}
