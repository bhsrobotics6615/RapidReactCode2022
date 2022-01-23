// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LidarSubsystem;
// import NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").getDouble(0);


public class TargetAim extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LidarSubsystem lidar_subsystem;
  @SuppressWarnings("unused") 
  private final DriveTrainSubsystem drive_subsystem;

  /** Creates a new LidarCommand. */
  public TargetAim(LidarSubsystem l_subsystem, DriveTrainSubsystem d_subsystem) {
    lidar_subsystem = l_subsystem;
    drive_subsystem = d_subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(l_subsystem);
    addRequirements(d_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    lidar_subsystem.findDistance(0);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
