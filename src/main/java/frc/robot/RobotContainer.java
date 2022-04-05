// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AlignAndLaunch;
import frc.robot.commands.Choking;
import frc.robot.commands.ClimbSequence;
import frc.robot.commands.ClimbToSecond;
import frc.robot.commands.ClimbToThird;
import frc.robot.commands.ClimberStageFour;
import frc.robot.commands.ClimberStageOne;
import frc.robot.commands.ClimberStageThree;
import frc.robot.commands.ClimberStageTwo;
import frc.robot.commands.Drive;
// import frc.robot.commands.DriveAuto;
import frc.robot.commands.IndexBall;
import frc.robot.commands.LiftDrawBridge;
import frc.robot.commands.LowerDrawBridge;
// import frc.robot.commands.ManualLower;
// import frc.robot.commands.ManualRaise;
import frc.robot.commands.PickUpBalls;
import frc.robot.commands.TerminateProcedures;
//import frc.robot.commands.SearchAndAlign;
import frc.robot.subsystems.BallPickerUpperSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrawBridgeSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TheFirst15;
import frc.robot.commands.AutoLiftDrawBridge;
import frc.robot.commands.AutoLowerDrawBridge;
import frc.robot.commands.AutoRunTheLauncher;
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
  
  //DriveTrain Setup
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
  public WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
  public WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7

  public MecanumDrive drive;

  //Subsystems
  private final DriveTrainSubsystem drive_subsystem = new DriveTrainSubsystem();
  private final LauncherSubsystem launcher_subsystem = new LauncherSubsystem();
  // private final LidarSubsystem lidar_subsystem = new LidarSubsystem();
  private final IndexerSubsystem indexer_subsystem = new IndexerSubsystem();
  private final BallPickerUpperSubsystem picker_upper_subsystem = new BallPickerUpperSubsystem();
  private final DrawBridgeSubsystem draw_bridge_subsystem = new DrawBridgeSubsystem();
  private final ClimberSubsystem climber_subsystem = new ClimberSubsystem();

  //Commands
  private final Drive drive_command = new Drive(drive_subsystem);


  // private final AutoSpeenCommand m_autoCommand = new AutoSpeenCommand(drive_subsystem);
 // private final PreLaunch pre_launch = new PreLaunch(lidar_subsystem, drive_subsystem);
  //private final RunTheLauncher run_launch = new RunTheLauncher(launcher_subsystem);
private final TheFirst15 run_auto = new TheFirst15(drive_subsystem, launcher_subsystem, indexer_subsystem, draw_bridge_subsystem);
  // private final DriveAuto run_drive_auto = new DriveAuto(drive_subsystem, 10);
  private final IndexBall index_ball = new IndexBall(indexer_subsystem);
  private final PickUpBalls pick_up_ball = new PickUpBalls(picker_upper_subsystem, indexer_subsystem);
  private final LowerDrawBridge lower_bpu = new LowerDrawBridge(draw_bridge_subsystem);
  private final LiftDrawBridge lift_bpu = new LiftDrawBridge(draw_bridge_subsystem);
  private final Choking ball_choking = new Choking(launcher_subsystem, indexer_subsystem);
  private final ClimberStageOne back_climber_extend = new ClimberStageOne(climber_subsystem);
  private final ClimberStageTwo back_climber_retract = new ClimberStageTwo(climber_subsystem);
  private final ClimberStageThree front_climber_extend = new ClimberStageThree(climber_subsystem);
  private final ClimberStageFour front_climber_retract = new ClimberStageFour(climber_subsystem);
  private final AutoLiftDrawBridge lift_Auto_BPU = new AutoLiftDrawBridge(draw_bridge_subsystem);
  private final AutoLowerDrawBridge lower_Auto_BPU = new AutoLowerDrawBridge(draw_bridge_subsystem);
  private final AutoRunTheLauncher run_launcher_auto = new AutoRunTheLauncher(launcher_subsystem, indexer_subsystem);
  private final ClimbToSecond climb_to_2nd = new ClimbToSecond(climber_subsystem, drive_subsystem);
  private final ClimbToThird climb_to_3rd = new ClimbToThird(climber_subsystem, drive_subsystem);

  //Controllers
  //public Joystick Logitech = new Joystick(Constants.JOYSTICK); // Port is 0 (OLD)
  public XboxController DriveController = new XboxController(Constants.DRIVE_CONTROLLER); // Port is 0
  public XboxController Xbox360 = new XboxController(Constants.XBOX); // Port is 1
  
  //Buttons
  public JoystickButton Run_Launcher = new JoystickButton(Xbox360, Constants.RUN_LAUNCHER);
  // public JoystickButton Run_Search_And_Align = new JoystickButton(Logitech, Constants.RUN_LIDAR);
  public JoystickButton Run_Indexer = new JoystickButton(Xbox360, Constants.RUN_INDEXER);
  public JoystickButton Run_BPU = new JoystickButton(Xbox360, Constants.RUN_BPU); //Ball Picker Upper
  public JoystickButton Lower_BPU = new JoystickButton(Xbox360, Constants.LOWER_BPU);
  public JoystickButton Lift_BPU = new JoystickButton(Xbox360, Constants.LIFT_BPU);
  public JoystickButton Un_choke = new JoystickButton(Xbox360, Constants.CHOKING);
  public JoystickButton Auto_Launch = new JoystickButton(Xbox360, Constants.AUTO_LAUNCH);
  public JoystickButton Front_Climber_Extend = new JoystickButton(DriveController, Constants.FRONT_CLIMBER_EXTEND);
  public JoystickButton Back_Climber_Extend = new JoystickButton(DriveController, Constants.BACK_CLIMBER_EXTEND);
  public JoystickButton Back_Climber_Retract = new JoystickButton(DriveController, Constants.BACK_CLIMBER_RETRACT);
  public JoystickButton Front_Climber_Retract = new JoystickButton(DriveController, Constants.FRONT_CLIMBER_RETRACT);
  public JoystickButton Lift_Auto_BPU = new JoystickButton(DriveController, Constants.Lift_Auto_BPU);
  public JoystickButton Lower_Auto_BPU = new JoystickButton(DriveController, Constants.Lower_Auto_BPU);
  public JoystickButton stop_all = new JoystickButton(Xbox360, Constants.KILL_BUTTON);
  public JoystickButton climb = new JoystickButton(DriveController, Constants.CLAMBER_22); 
  public JoystickButton climb_climb = new JoystickButton(DriveController, Constants.CLAMBER_23); 

  // public 
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure driveTrain
    frontRight.setInverted(true);
    backRight.setInverted(true);
    
    drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

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
    
    //Run_Search_And_Align.whenPressed(search_and_align);
    Run_BPU.whileHeld(pick_up_ball);
    Run_Indexer.whileHeld(index_ball);
    Lift_BPU.whileHeld(lift_bpu);
    Lower_BPU.whileHeld(lower_bpu);
    Un_choke.whileHeld(ball_choking);
    Auto_Launch.whenPressed(new AlignAndLaunch(drive_subsystem, launcher_subsystem, indexer_subsystem));
    Back_Climber_Extend.whileHeld(back_climber_extend);
    Back_Climber_Retract.whileHeld(back_climber_retract);
    Front_Climber_Extend.whenPressed(front_climber_extend); 
    Front_Climber_Retract.whenPressed(front_climber_retract);
    Run_Launcher.whenPressed(run_launcher_auto);
    Lift_Auto_BPU.whenPressed(lift_Auto_BPU);
    Lower_Auto_BPU.whenPressed(lower_Auto_BPU);
    stop_all.whenPressed(new TerminateProcedures(picker_upper_subsystem, climber_subsystem, draw_bridge_subsystem, drive_subsystem, indexer_subsystem, launcher_subsystem));
    climb.whenPressed(climb_to_2nd);
    climb_climb.whenPressed(climb_to_3rd);

    //Auto_Launch.whenPressed(new AutoRunTheLauncher(launcher_subsystem, indexer_subsystem));

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
