// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrawBridgeSubsystem;

public class AutoDesiredDrawBridge extends CommandBase {
  /** Creates a new AutoDesiredDrawBridge. */
  DrawBridgeSubsystem drawBridge;
  boolean flag;
  boolean isFinished = false;
  public AutoDesiredDrawBridge(DrawBridgeSubsystem drawBridge, boolean flag) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drawBridge = drawBridge;
    //If the flag is TRUE, then the command thinks the encoder is already at the desired position and will therefore lower the drawbridge to the default position
    this.flag = flag;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    if(flag == true)
    {
      drawBridge.setEncoderInverted();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if(flag == false)
    {
      while(drawBridge.getRawEncoderCount() < Constants.DESIRED_POSITION)
      {
        drawBridge.liftAuto(Constants.LIFT_AUTO_POWER);
      }
    }
    else
    {
      while(drawBridge.getRawEncoderCount() < Constants.LOWER_FLAT)
      {
        drawBridge.lowerAuto(Constants.LOWER_AUTO_POWER);
      }
    }
    isFinished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drawBridge.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
