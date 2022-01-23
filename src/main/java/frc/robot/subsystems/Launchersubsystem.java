// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import frc.robot.Variables;

public class LauncherSubsystem extends SubsystemBase {
  /** Creates a new LauncherSubsystem. */
  
  PWMTalonSRX launcher = new PWMTalonSRX(Constants.LAUNCHER);

  public void rev() {
    
    Variables.launcherSpeed = Constants.speedConvConst / Math.sin(Variables.thetaDegrees);
    launcher.set(Variables.launcherSpeed);
    
  }

  public void stop() {

    launcher.set(0);
    
  }
}