// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Choking;
import frc.robot.commands.Drive;
import frc.robot.commands.IndexBall;
import frc.robot.commands.LiftDrawBridge;
import frc.robot.commands.LowerDrawBridge;
import frc.robot.commands.PickUpBalls;
import frc.robot.commands.RunTheLauncher;
import frc.robot.commands.SearchAndAlign;
import frc.robot.subsystems.BallPickerUpperSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
// import frc.robot.subsystems.LidarSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TheFirst15;

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
  
  //Subsystems
  private final LauncherSubsystem launcher_subsystem = new LauncherSubsystem();
  // private final LidarSubsystem lidar_subsystem = new LidarSubsystem();
  private final DriveTrainSubsystem drive_subsystem = new DriveTrainSubsystem();
  private final IndexerSubsystem indexer_subsystem = new IndexerSubsystem();
  private final BallPickerUpperSubsystem picker_upper_subsystem = new BallPickerUpperSubsystem();
  private final DrawBridgeSubsystem draw_bridge_subsystem = new DrawBridgeSubsystem();

  //Commands
  private final Drive drive_command = new Drive(drive_subsystem);

  // private final AutoSpeenCommand m_autoCommand = new AutoSpeenCommand(drive_subsystem);
  private final SearchAndAlign search_and_align = new SearchAndAlign(drive_subsystem);
  private final RunTheLauncher run_launch = new RunTheLauncher(launcher_subsystem, indexer_subsystem);
  private final TheFirst15 run_auto = new TheFirst15(drive_subsystem, launcher_subsystem/*, lidar_subsystem*/);
  private final IndexBall index_ball = new IndexBall(indexer_subsystem);
  private final PickUpBalls pick_up_ball = new PickUpBalls(picker_upper_subsystem);
  private final LowerDrawBridge lower_bpu = new LowerDrawBridge(draw_bridge_subsystem);
  private final LiftDrawBridge lift_bpu = new LiftDrawBridge(draw_bridge_subsystem);
  private final Choking ball_choking = new Choking(launcher_subsystem, indexer_subsystem);

  //Controllers
  public Joystick Logitech = new Joystick(Constants.JOYSTICK); // Port is 0
  public XboxController Xbox360 = new XboxController(Constants.XBOX); // Port is 1

  //Buttons
  public JoystickButton Run_Launcher = new JoystickButton(Xbox360, Constants.RUN_LAUNCHER);
  public JoystickButton Run_Search_And_Align = new JoystickButton(Logitech, Constants.RUN_LIDAR);
  public JoystickButton Run_Indexer = new JoystickButton(Xbox360, Constants.RUN_INDEXER);
  public JoystickButton Run_BPU = new JoystickButton(Xbox360, Constants.RUN_BPU); //Ball Picker Upper
  public JoystickButton Lower_BPU = new JoystickButton(Xbox360, Constants.LOWER_BPU);
  public JoystickButton Lift_BPU = new JoystickButton(Xbox360, Constants.LIFT_BPU);
  public JoystickButton Un_choke = new JoystickButton(Xbox360, Constants.CHOKING);

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
    Run_Search_And_Align.whenPressed(search_and_align);
    Run_BPU.whileHeld(pick_up_ball);
    Run_Indexer.whileHeld(index_ball);
    Lift_BPU.whileHeld(lift_bpu);
    Lower_BPU.whileHeld(lower_bpu);
    Un_choke.whileHeld(ball_choking);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    return run_auto;
  }
}
