// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
//import edu.wpi.first.wpilibj.DigitalInput;

public class ClimberStageOne extends CommandBase {
 
  /*DigitalInput back_climb_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_TOP_LIMIT);
  DigitalInput front_climb_left_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_1_LIMIT_SWITCH);
  DigitalInput front_climb_right_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_2_LIMIT_SWITCH);
*/
  private final ClimberSubsystem climbers;
  // private double startTime;
  private boolean hasClimbEnded = false;

  /** Creates a new ClimberStageOne. */
  public ClimberStageOne(ClimberSubsystem climber_subsystem) {
    climbers = climber_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
      climbers.back_climber_extend();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbers.back_climber_off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hasClimbEnded;
  }
}
