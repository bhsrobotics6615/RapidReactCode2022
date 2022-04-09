// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Variables;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ClimbToSecond extends CommandBase {
  /** Creates a new ClimbSequence. */

  private ClimberSubsystem climber_subsystem;
  private DriveTrainSubsystem drive_subsystem;
  DigitalInput front_climb_right_limit_Switch = Variables.front_climb_right_limit_switch; 
  DigitalInput front_climb_left_limit_Switch = Variables.front_climb_left_limit_switch; 
  DigitalInput back_climb_limit_switch = Variables.back_climb_limit_switch;
  private boolean finished;

  public ClimbToSecond(ClimberSubsystem c_subsystem, DriveTrainSubsystem d_subsystem) {
    
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
      System.out.println("BACK GOING UP!!!");

    } while (back_climb_limit_switch.get());

    climber_subsystem.back_climber_off();

    do {

      drive_subsystem.move(0.5, 0, 0);
      System.out.println("JERKING....");

    } while (Variables.yJerk < -1 && Variables.yJerk == 0);

    drive_subsystem.stop();

    do {

      climber_subsystem.back_climber_retract();
      System.out.println("BACK GOING DOWN!!!");

    } while (back_climb_limit_switch.get());

    climber_subsystem.back_climber_off();

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
