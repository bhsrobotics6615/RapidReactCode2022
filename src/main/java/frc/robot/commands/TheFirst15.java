// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
//import frc.robot.commands.AlignAndLaunch;
//import frc.robot.commands.DriveAuto;

// import frc.robot.subsystems.LidarSubsystem;


public class TheFirst15 extends SequentialCommandGroup {
  /** Creates a new TheFirst15. */
  public TheFirst15(DriveTrainSubsystem driveTrain, LauncherSubsystem launcher, IndexerSubsystem indexer/*, LidarSubsystem limelight*/, DrawBridgeSubsystem drawBridge ) {
    // Use addRequirements() here to declare subsystem dependencies.
     addCommands(
      new ParallelCommandGroup(new DriveAuto(driveTrain, 8), new AutoLowerDrawBridge(drawBridge)),
      new AlignAndLaunch(driveTrain, launcher, indexer));
      //new TargetAim(limelight, driveTrain)
    // );
  }
}

