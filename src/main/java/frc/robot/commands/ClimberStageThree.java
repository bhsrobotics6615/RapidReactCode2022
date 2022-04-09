// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Variables;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberStageThree extends CommandBase {

  private final ClimberSubsystem climbers;
  public double startTime;
  
  DigitalInput front_climb_right_limit_Switch = Variables.front_climb_right_limit_switch; 
  DigitalInput front_climb_left_limit_Switch = Variables.front_climb_left_limit_switch; 
  DigitalInput back_climb_limit_switch = Variables.back_climb_limit_switch;

  


  /** Creates a new ClimberStageOne. */
  public ClimberStageThree(ClimberSubsystem climber_subsystem) {
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
  public void execute() {
    // while (Timer.getFPGATimestamp() < startTime + 2.3){
      
      climbers.front_right_climber_extend();
      climbers.front_left_climber_extend();
      double timepassed = startTime + 1.5;
      if(front_climb_left_limit_Switch.get() == false && Timer.getFPGATimestamp() > timepassed ){
          climbers.front_left_climber_stop();

      }

      if(front_climb_right_limit_Switch.get() == false &&  Timer.getFPGATimestamp() > timepassed ){
        climbers.front_right_climber_stop();

    }
             
    // }
    // if (Timer.getFPGATimestamp() >= startTime + 2.3){
      // Variables.hasClimbEnded = true;
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
