// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;
  public static Accelerometer accelerometer = new BuiltInAccelerometer();
  public static LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
  double prevXAccel = 0;
  double prevYAccel = 0;
  int run_counter = 1;
  int run_clock = 0;
  final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
  final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
  final WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
  final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7
  final double kCOUNTS_FEET = (1/64)*(10.71/1)*(6*Math.PI) *
        (1/12);
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
   
    frontLeft.setInverted(true);
    frontRight.setInverted(false);
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
    backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);

    frontLeft.setSensorPhase(false);
    frontRight.setSensorPhase(true);
    
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    // Gets the current accelerations in the X and Y directions
    double filteredXAccel = xAccelFilter.calculate(accelerometer.getX());
    double yAccel = accelerometer.getY();

    // Calculates the jerk in the X and Y directions
    // Divides by .02 because default loop timing is 20ms
    
    double xJerk = (filteredXAccel - prevXAccel) / .02;
    
    double yJerk = (yAccel - prevYAccel) / .02;

    if (run_counter == 50) {

      System.out.println("xJerk: "+xJerk);
      System.out.println("yJerk: "+yJerk);
      System.out.println(run_counter);
      System.out.println(run_clock);
      System.out.println();
      run_counter = 1;
      run_clock ++;

    } else {

      run_counter ++;
      run_clock ++;

    }

    

    prevXAccel = filteredXAccel;
    prevYAccel = yAccel;

  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
 
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    frontLeft.setSelectedSensorPosition(0,0,10);
    frontRight.setSelectedSensorPosition(0,0,10);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() { double leftPosition = frontLeft.getSelectedSensorPosition() * kCOUNTS_FEET;
    double rightPosition = frontRight.getSelectedSensorPosition() * kCOUNTS_FEET;
    double distance = (leftPosition + rightPosition)/2;}
 
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
