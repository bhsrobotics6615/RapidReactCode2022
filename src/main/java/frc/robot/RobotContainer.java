// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoSpeenCommand;
import frc.robot.commands.Drive;
import frc.robot.commands.RunTheLauncher;
import frc.robot.commands.TargetAim;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LidarSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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
  
  //Subsystems
  private final LauncherSubsystem launcher_subsystem = new LauncherSubsystem();
  private final LidarSubsystem lidar_subsystem = new LidarSubsystem();
  private final DriveTrainSubsystem drive_subsystem = new DriveTrainSubsystem();

  //Commands
  private final Drive drive_command = new Drive(drive_subsystem);
  private final AutoSpeenCommand m_autoCommand = new AutoSpeenCommand(drive_subsystem);
  private final TargetAim run_lidar = new TargetAim(lidar_subsystem, drive_subsystem);
  private final RunTheLauncher run_launch = new RunTheLauncher(launcher_subsystem);

  //Controllers
  public Joystick Logitech = new Joystick(Constants.JOYSTICK); // Port is 0
  public XboxController Xbox360 = new XboxController(Constants.XBOX); // Port is 1

  //Buttons
  public JoystickButton Run_Launcher = new JoystickButton(Xbox360, Constants.RUN_LAUNCHER);
  public JoystickButton Run_Lidar = new JoystickButton(Logitech, Constants.RUN_LIDAR);

  // public 
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure default commands
    drive_subsystem.setDefaultCommand(drive_command);
    // launcher_subsystem.setDefaultCommand(run_launch);

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
    
    Run_Launcher.whileHeld(run_launch);
    Run_Lidar.whenPressed(run_lidar);
    
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
