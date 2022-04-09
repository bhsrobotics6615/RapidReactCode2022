// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Variables;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberStageTwo extends CommandBase {
  private final ClimberSubsystem climbers;

  /** Creates a new ClimberStageTwo. */
  public ClimberStageTwo(ClimberSubsystem climber_Subsystem) {
    climbers = climber_Subsystem;
    addRequirements(climber_Subsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      // climbers.front_climber_extend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Variables.canIBackItUp){
          climbers.back_climber_retract();
        }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbers.back_climber_off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
