// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
// import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.BallPickerUpperSubsystem;

public class ClimberStageOne extends CommandBase {

  private final ClimberSubsystem climbers;
  private final DrawBridgeSubsystem bpu;

  /** Creates a new ClimberStageOne. */
  public ClimberStageOne(ClimberSubsystem climber_subsystem, DrawBridgeSubsystem bpu_subsystem) {
    climbers = climber_subsystem;
    bpu = bpu_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_subsystem, bpu_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: initialize the front and back hooks to be in the proper position
    bpu.lower();
  }


@Override
  public void execute() {
    // TODO: Create sequence of events as follows: 
    // TODO: 1) Lower back hook until latch limit switch is TRUE
    // TODO: 2) Turn off back hook motor (limit switch TRUE stops motor)
    // TODO: 3) Extend front hooks
    // TODO: 4) Lift the bpu
    // TODO: 5) Lower the front hooks until back hooks lift off of the rung
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
