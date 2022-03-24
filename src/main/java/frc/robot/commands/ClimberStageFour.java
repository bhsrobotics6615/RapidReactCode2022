// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberStageFour extends CommandBase {

  private final ClimberSubsystem climbers;
  private double startTime;
  public static boolean hasClimbEnded = false;
  
  // Creates a new ClimberStageOne. 
  public ClimberStageFour(ClimberSubsystem climber_subsystem) {
    climbers = climber_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() 
  {
    while (Timer.getFPGATimestamp() < startTime + 2){
      climbers.front_climber_retract();
    }
    if (Timer.getFPGATimestamp() >= startTime + 2){
      hasClimbEnded = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbers.front_climber_stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hasClimbEnded;
  }
}

