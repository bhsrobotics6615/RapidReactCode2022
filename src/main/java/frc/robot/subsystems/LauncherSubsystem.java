// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Variables;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new LauncherSubsystem. */
  
  WPI_TalonSRX launcher = new WPI_TalonSRX(Constants.LAUNCHER);

  public void rev() {
    Variables.launcherSpeed = 1;
    // Variables.launcherSpeed = Constants.SPEED_CONVERT / Math.sin(Variables.thetaDegrees);
    launcher.set(-(Variables.launcherSpeed));
    System.out.println("LAUNCHER " + Constants.LAUNCHER);
    System.out.println("launcherSpeed " + Variables.launcherSpeed);
    
  }

  public void reverse() {

    Variables.launcherSpeed = 1;
    // Variables.launcherSpeed = Constants.SPEED_CONVERT / Math.sin(Variables.thetaDegrees);
    launcher.set(Variables.launcherSpeed);
    System.out.println("LAUNCHER " + Constants.LAUNCHER);
    System.out.println("launcherSpeed " + Variables.launcherSpeed);

  }

  public void stop() {
    launcher.set(0);
  }

}
