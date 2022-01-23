// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LidarSubsystem;


public class TheFirst15 extends SequentialCommandGroup {
  /** Creates a new TheFirst15. */
  public TheFirst15(DriveTrainSubsystem driveTrain, LauncherSubsystem launcher, LidarSubsystem limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(
      new DriveAuto(driveTrain),
      new RunTheLauncher(launcher),
      new TargetAim(limelight, driveTrain)
    );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
