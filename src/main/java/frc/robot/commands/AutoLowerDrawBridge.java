// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrawBridgeSubsystem;

public class AutoLowerDrawBridge extends CommandBase {
  /** Creates a new AutoLowerDrawBridge. */
  private final DrawBridgeSubsystem lower_bridge;
  boolean isLowerFinished = false ;
  public AutoLowerDrawBridge( DrawBridgeSubsystem subsystem) {
    lower_bridge = subsystem;
    addRequirements(lower_bridge);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lower_bridge.resets();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while(lower_bridge.getRawEncoderValue() > -1500){
       System.out.println(lower_bridge.getRawEncoderValue());
      lower_bridge.lower();
    }
    isLowerFinished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lower_bridge.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isLowerFinished;
  }
}
