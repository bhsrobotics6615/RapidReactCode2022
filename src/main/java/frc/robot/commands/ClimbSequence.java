// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Variables;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ClimbSequence extends CommandBase {
  /** Creates a new ClimbSequence. */

  private ClimberSubsystem climber_subsystem;
  private DriveTrainSubsystem drive_subsystem;
  DigitalInput front_climb_right_limit_Switch = Variables.front_climb_right_limit_switch; 
  DigitalInput front_climb_left_limit_Switch = Variables.front_climb_left_limit_switch; 
  DigitalInput back_climb_limit_switch = Variables.back_climb_limit_switch;
  private boolean finished;

  public ClimbSequence(ClimberSubsystem c_subsystem, DriveTrainSubsystem d_subsystem) {
    
    climber_subsystem = c_subsystem;
    drive_subsystem = d_subsystem;
    finished = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(c_subsystem);
    addRequirements(d_subsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Stage One, Extend Climber, Backup, Pull up
    do {

      climber_subsystem.back_climber_extend();

    } while (!back_climb_limit_switch.get());

    do {

      drive_subsystem.move(0.2, 0, 0);

    } while (Variables.yJerk < -5);

    drive_subsystem.stop();

    do {

      climber_subsystem.back_climber_retract();

    } while (!back_climb_limit_switch.get());

    // Stage Two, Extend Front Climbers, Grab, Pull up
    do {

      climber_subsystem.front_climber_extend();

    } while (!(front_climb_right_limit_Switch.get() && front_climb_left_limit_Switch.get()));

    do {

    } while (Variables.yJerk > 5 || Variables.yJerk < -5);

    do {

      climber_subsystem.front_climber_retract();

    } while (!(front_climb_right_limit_Switch.get() && front_climb_left_limit_Switch.get()));

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
