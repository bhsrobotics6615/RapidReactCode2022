// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.Constants;
import frc.robot.subsystems.IndexerSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoRunTheLauncher extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LauncherSubsystem launch_subsystem;
  private final IndexerSubsystem indexer_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
   private boolean hasLauncherEnded = false;
   private double startTime;

  public AutoRunTheLauncher(LauncherSubsystem l_subsystem, IndexerSubsystem i_subsystem, double seconds) {
    launch_subsystem = l_subsystem;
    indexer_subsystem = i_subsystem;
    addRequirements(l_subsystem);
    addRequirements(i_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){ 
    while (Timer.getFPGATimestamp() < (startTime + Constants.LAUNCH_RUN_TIME)) {
      launch_subsystem.rev();
      
      // if (Timer.hasElapsed(Constants.LAUNCH_RUN_TIME - Constants.INDEX_TIME)) {
      
      if (Timer.getFPGATimestamp() > (startTime + Constants.LAUNCH_RUN_TIME - Constants.INDEX_TIME)) {
        indexer_subsystem.load();
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    launch_subsystem.stop();
    indexer_subsystem.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return hasLauncherEnded;
    
  }
}
