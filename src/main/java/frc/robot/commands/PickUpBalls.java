// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import  frc.robot.subsystems.BallPickerUpperSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PickUpBalls extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final BallPickerUpperSubsystem ball_picker_upper_subsystem;
  private final IndexerSubsystem i_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PickUpBalls(BallPickerUpperSubsystem subsystem, IndexerSubsystem index_subsystem) {
    // ball_picker_upper_subsystem.wait();
    ball_picker_upper_subsystem = subsystem;
    i_subsystem = index_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    ball_picker_upper_subsystem.pickUpTheBall();
    i_subsystem.loadSetSpeed(0.40);
    // System.out.println("SUCKING!!!");
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    ball_picker_upper_subsystem.stopBPU();
    i_subsystem.stop();
    // System.out.println("Stopping...");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
