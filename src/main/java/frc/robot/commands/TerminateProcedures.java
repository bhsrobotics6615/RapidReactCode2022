// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallPickerUpperSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

public class TerminateProcedures extends CommandBase {
  BallPickerUpperSubsystem ball_picker_upper;
  ClimberSubsystem climber;
  DrawBridgeSubsystem draw_bridge;
  DriveTrainSubsystem drive_train;
  IndexerSubsystem indexer;
  LauncherSubsystem launcher;
  boolean finished;

  /** Creates a new TerminateProcedures. */
  public TerminateProcedures(BallPickerUpperSubsystem bp_subsystem, ClimberSubsystem c_subsystem, DrawBridgeSubsystem db_subsystem, DriveTrainSubsystem dt_subsystem, IndexerSubsystem i_subsystem, LauncherSubsystem la_subsystem) {
    
    ball_picker_upper = bp_subsystem;
    climber = c_subsystem;
    draw_bridge = db_subsystem;
    drive_train = dt_subsystem;
    indexer = i_subsystem;
    launcher = la_subsystem;
    finished = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(bp_subsystem);
    addRequirements(c_subsystem);
    addRequirements(db_subsystem);
    addRequirements(dt_subsystem);
    addRequirements(i_subsystem);
    addRequirements(la_subsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    ball_picker_upper.stopBPU();
    climber.toString();
    draw_bridge.stop();
    drive_train.stop();
    indexer.stop();
    launcher.stop();
    finished = true;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
