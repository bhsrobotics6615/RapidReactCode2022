// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoSpeenCommand;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrainSubsystem drive_subsystem = new DriveTrainSubsystem();
  private final DriveTrainCommand drive_command = new DriveTrainCommand(drive_subsystem);
  private final AutoSpeenCommand m_autoCommand = new AutoSpeenCommand(drive_subsystem);

  // public final PWMTalonSRX frontRight = new PWMTalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 1
  // public final PWMTalonSRX backRight = new PWMTalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 2
  // public final PWMTalonSRX backLeft = new PWMTalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 3
  // public final PWMTalonSRX frontLeft = new PWMTalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 4

  public Joystick Logitech = new Joystick(Constants.JOYSTICK); // Port is 0
  public XboxController Xbox360 = new XboxController(Constants.XBOX); // Port is 1

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure default commands

      // drive_subsystem.setDefaultCommand(
      //   new RunCommand(
      //       () ->
      //           drive_subsystem.Move(0, 0, 0),
      //       drive_subsystem));

      drive_subsystem.setDefaultCommand(drive_command);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
