// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Limelight;
import frc.robot.Constants;

public class SearchAndAlign extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem drive_subsystem;
  private boolean hasFinished;

  /** Creates a new SearchAndAlign. */
  public SearchAndAlign(DriveTrainSubsystem d_subsystem) {
    drive_subsystem = d_subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(d_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    hasFinished = false;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double x_offset = Limelight.getX();
    double y_offset = Limelight.getY();
    boolean hasTarget = Limelight.hasTarget();

    double x_move = 0;
    double y_move = 0;
    double rotation = 0;

    if (!hasTarget) {

      // We don't see the target, seek for the target by spinning in place at a safe
      // speed.
      // Search
      rotation = Constants.SEARCH_ROTATION_SPEED;

    } else {

      // We do see the target, execute aiming code
      // Align

      if (x_offset < Constants.LIMELIGHT_TARGET_X + Constants.LIMELIGHT_X_PRECISION &&
          x_offset > Constants.LIMELIGHT_TARGET_X - Constants.LIMELIGHT_X_PRECISION &&
          y_offset < Constants.LIMELIGHT_TARGET_Y + Constants.LIMELIGHT_Y_PRECISION &&
          y_offset > Constants.LIMELIGHT_TARGET_Y - Constants.LIMELIGHT_Y_PRECISION) {

        hasFinished = true;

      }

      if (x_offset > Constants.LIMELIGHT_X_PRECISION + Constants.LIMELIGHT_TARGET_X) {

        rotation = Constants.ALIGN_ROTATION_SPEED;

      } else if (x_offset < -Constants.LIMELIGHT_X_PRECISION + Constants.LIMELIGHT_TARGET_X) {

        rotation = -Constants.ALIGN_ROTATION_SPEED;

      }

      if (y_offset > Constants.LIMELIGHT_Y_PRECISION + Constants.LIMELIGHT_TARGET_Y) {

        y_move = -Constants.ALIGN_MOVEMENT_SPEED;

      } else if (y_offset < -Constants.LIMELIGHT_Y_PRECISION + Constants.LIMELIGHT_TARGET_Y) {

        y_move = Constants.ALIGN_MOVEMENT_SPEED;

      }
    }
    drive_subsystem.move(y_move, x_move, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive_subsystem.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return hasFinished;

  }
}
