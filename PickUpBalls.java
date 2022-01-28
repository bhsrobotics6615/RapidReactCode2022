// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import  frc.robot.subsystems.BallPickerUpper;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
import frc.robot.Robot;

/** An example command that uses an example subsystem. */
public class PickUpBalls extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final BallPickerUpper ball_picker_upper_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PickUpBalls(BallPickerUpper subsystem) {
    // ball_picker_upper_subsystem.wait();
    ball_picker_upper_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.ballPickerUpper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ball_picker_upper_subsystem.pickUpTheBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
