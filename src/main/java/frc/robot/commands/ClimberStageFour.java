// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Variables;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberStageFour extends CommandBase {

  private final ClimberSubsystem climbers;
  private double startTime;
  // Variables.hasClimbEnded = false;

  DigitalInput front_climb_right_limit_Switch = Variables.front_climb_right_limit_switch; 
  DigitalInput front_climb_left_limit_Switch = Variables.front_climb_left_limit_switch; 
  DigitalInput back_climb_limit_switch = Variables.back_climb_limit_switch;
  
  // Creates a new ClimberStageOne. 
  public ClimberStageFour(ClimberSubsystem climber_subsystem) {
    climbers = climber_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Variables.hasClimbEnded = false;
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() 
  { climbers.front_right_climber_retract();
    climbers.front_left_climber_retract();
    double timepassed = startTime + 2.5;
    if( Timer.getFPGATimestamp() > timepassed ){
        climbers.front_climber_stop();
    }

    
    /*do {

      climbers.front_right_climber_retract();
      climbers.front_left_climber_retract();

      if ((front_climb_right_limit_Switch.get() && front_climb_left_limit_Switch.get())) {

        Variables.atBottom = true;

      }

    } while ((front_climb_right_limit_Switch.get() && front_climb_left_limit_Switch.get()) == true || !Variables.atBottom);

    if((front_climb_right_limit_Switch.get() && front_climb_left_limit_Switch.get()) == false)
    {
      Variables.hasClimbEnded = true;
      Variables.atBottom = true;
    }*/
    // while (Timer.getFPGATimestamp() < startTime + 2.3){
    //   climbers.front_climber_retract();
    // }
    // if (Timer.getFPGATimestamp() >= startTime + 2.3){
    //   hasClimbEnded = true;
    //   Variables.atBottom = true;
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbers.front_climber_stop();
    Variables.hasClimbEnded = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Variables.hasClimbEnded;
  }
}

