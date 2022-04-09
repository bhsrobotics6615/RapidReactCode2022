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

  double heightDif;
  double numerator;
  double denominator;

  public void rev() {
 
    launcher.set(-(Variables.launcherSpeed));
    
  }

  public void reverse() {

    launcher.set(0.2);

  }

  // Finds velocity required for distance
  public double findVelocity(double distance) {

    heightDif = Constants.HEIGHT_OF_HUB - Constants.HEIGHT_OF_LAUNCHER; // Difference between height of the hub and height of the launcher

    numerator = -32.2 * Math.pow(distance, 2);
    denominator = 2 * Math.pow(Math.cos(Constants.LAUNCHER_ANGLE), 2) * (heightDif - distance * Math.tan(Constants.LAUNCHER_ANGLE));
    return Math.pow(numerator / denominator, 0.5);

  }

  public void stop() {
    launcher.stopMotor();
  }

}
