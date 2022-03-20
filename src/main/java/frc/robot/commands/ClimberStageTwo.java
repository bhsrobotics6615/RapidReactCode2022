// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;


public class ClimberStageTwo extends CommandBase {
  private final ClimberSubsystem climbers;
  private boolean up;
  private boolean done;

  /** Creates a new ClimberStageTwo. */
  public ClimberStageTwo(ClimberSubsystem climber_Subsystem) {
    climbers = climber_Subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_Subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    up = false;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    done = false;

    do {

      if (up) {

        climbers.backClimberExtend();

      } else if (!up) {

        climbers.backClimberRetract();

      }

    } while(!climbers.getClimber2Value());
      
    up = !up;
    done = true;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    climbers.backClimberStop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return done;

  }
}
