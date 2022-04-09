// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AlignAndLaunch extends SequentialCommandGroup {
  private final DriveTrainSubsystem drive_subsystem;
  private final LauncherSubsystem launch_subsystem;
  private final IndexerSubsystem indexer_subsystem;
  /** Creates a new AlignAndLaunch. */
  public AlignAndLaunch(DriveTrainSubsystem d_subsystem, LauncherSubsystem l_subsystem, IndexerSubsystem i_subsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    drive_subsystem = d_subsystem;
    launch_subsystem = l_subsystem;
    indexer_subsystem = i_subsystem;

    addCommands(new SearchAndAlign(drive_subsystem), new AutoRunTheLauncher(launch_subsystem, indexer_subsystem));
  }
}
