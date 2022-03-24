// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberSequence extends SequentialCommandGroup {
  // private final DriveTrainSubsystem drive_train;
  private final ClimberSubsystem climbers;
  /** Creates a new ClimberSequence. */
  public ClimberSequence(ClimberSubsystem climb) {
    // Use addRequirements() here to declare subsystem dependencies.
    // drive_train = d_train;
    climbers = climb;

    addCommands(new ClimberStageThree(climbers), new ClimberStageFour(climbers));
  }
}
