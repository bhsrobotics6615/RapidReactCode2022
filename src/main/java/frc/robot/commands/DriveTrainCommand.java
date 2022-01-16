package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainCommand extends CommandBase {
    private final DriveTrainSubsystem drive_subsystem;
    

    public DriveTrainCommand(DriveTrainSubsystem subsystem) {
        drive_subsystem = subsystem;

        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drive_subsystem.Move(
        Robot.m_robotContainer.Logitech.getY(), 
        Robot.m_robotContainer.Logitech.getX(),
        Robot.m_robotContainer.Logitech.getZ());
        // drive_subsystem.SmoothOutput();

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive_subsystem.Stop();
    }

}
