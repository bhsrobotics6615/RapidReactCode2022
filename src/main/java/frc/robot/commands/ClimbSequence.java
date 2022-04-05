// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ClimbSequence extends CommandBase {
  /** Creates a new ClimbSequence. */

  private ClimberSubsystem climber_subsystem;
  private DriveTrainSubsystem drive_subsystem;

  public ClimbSequence(ClimberSubsystem c_subsystem, DriveTrainSubsystem d_subsystem) {
    
    climber_subsystem = c_subsystem;
    drive_subsystem = d_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(c_subsystem);
    addRequirements(d_subsystem);

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
