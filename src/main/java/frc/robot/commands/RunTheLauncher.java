// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class RunTheLauncher extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final LauncherSubsystem launch_subsystem;
  private final IndexerSubsystem indexer_subsystem;
  public Timer timer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunTheLauncher(LauncherSubsystem launcher, IndexerSubsystem indexer) {
    launch_subsystem = launcher;
    indexer_subsystem = indexer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(launcher);
    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (!timer.hasElapsed(Constants.LAUNCH_RUN_TIME)) {
      launch_subsystem.rev();
      System.out.println("REV UP THOSE FRYERS!");
      if (timer.hasElapsed(Constants.LAUNCH_RUN_TIME - Constants.INDEX_TIME)) {
        indexer_subsystem.load();
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    launch_subsystem.stop();
    System.out.println("Launchers done...");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
