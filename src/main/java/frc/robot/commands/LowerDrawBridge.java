// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrawBridgeSubsystem;

public class LowerDrawBridge extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrawBridgeSubsystem bpu;
  boolean isDone;
  public LowerDrawBridge(DrawBridgeSubsystem subsystem) {
    bpu = subsystem;
    isDone = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    bpu.resetEncoder();
    bpu.reverseEncoder(true);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while(bpu.getRawEncoderValue() < 2310)// 2130 encoder raw value for when darwbridge goes up
    {
      bpu.lower();
      
    }

    isDone = true;
   }
    
    

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    bpu.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
