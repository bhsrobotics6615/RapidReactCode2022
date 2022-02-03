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
    // Variables.launcherSpeed = Constants.speedConvConst / Math.sin(Variables.thetaDegrees);
    launcher.set(Variables.launcherSpeed);
    
  }

  public void setLaunchSpeedAuto() {

    double autoLaunchSpeed = Math.sqrt(Constants.GRAV * Math.pow(Variables.scoreDistance, 2) / (2 * (Math.pow(Math.cos(Variables.thetaDegrees),2) * ((Variables.scoreDistance * Math.tan(Variables.thetaDegrees)) - Constants.HIGH_SCORE))));
    launcher.set(autoLaunchSpeed);
    
  }

  public void stop() {

    launcher.set(0);
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
