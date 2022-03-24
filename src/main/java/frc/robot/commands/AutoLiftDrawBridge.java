// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrawBridgeSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutoLiftDrawBridge extends CommandBase {
  /** Creates a new AutoLiftDrawBridge. */
  private final DrawBridgeSubsystem draw_bridge;
  boolean isLiftFinished = false;
  
  public AutoLiftDrawBridge(DrawBridgeSubsystem subsystem) {
    draw_bridge = subsystem;

    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    draw_bridge.resets();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    while( draw_bridge.getRawEncoderValue() < 2000){
       System.out.println(draw_bridge.getRawEncoderValue());
      draw_bridge.lift();
    }
    isLiftFinished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    draw_bridge.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return isLiftFinished;
  }
}
