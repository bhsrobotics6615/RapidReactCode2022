package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Robot;
// import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

// DriveTrainManual command interprets the user's input and then moves the robot accordingly

public class DriveTrainManual extends CommandBase {
    private final DriveTrainSubsystem drive_subsystem;

    public DriveTrainManual(DriveTrainSubsystem subsystem) {
        drive_subsystem = subsystem;

        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() { }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // Get input from the IO controller

        // Move the robot
        double x = 1;
        double y = 2;
        double z = 3;
        drive_subsystem.Move(y, x, z);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive_subsystem.Stop();
    }

}
