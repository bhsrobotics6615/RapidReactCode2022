// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
// import edu.wpi.first.wpilibj.DigitalInput;

public class ClimberStageOne extends CommandBase {

  private final ClimberSubsystem climbers;
  private double backClimb;
  private double complete;
  /** Creates a new ClimberStageOne. */
  public ClimberStageOne(ClimberSubsystem climber_subsystem) {
    climbers = climber_subsystem;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: initialize the front and back hooks to be in the proper position
    
    backClimb = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
   
    
   
    while ( Timer.getFPGATimestamp() < (backClimb + Constants.back_climber_extend_time)){
      
         climbers.backClimberExtend();
         
      }
  }  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbers.backClimberStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
