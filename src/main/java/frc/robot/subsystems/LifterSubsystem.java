// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Variables;

public class LifterSubsystem extends SubsystemBase {
  /** Creates a new LifterSubsystem. */
  
  WPI_TalonSRX lifter = new WPI_TalonSRX(Constants.LIFTER);


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
