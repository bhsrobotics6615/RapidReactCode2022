package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutoSpeenCommand extends CommandBase{
    private final DriveTrainSubsystem speen_drive;


    public AutoSpeenCommand(DriveTrainSubsystem subsystem) {
        speen_drive = subsystem;

        addRequirements(subsystem);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        speen_drive.move(0, 0, 0.5);
        // drive_subsystem.SmoothOutput();

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        speen_drive.stop();
    }

}
