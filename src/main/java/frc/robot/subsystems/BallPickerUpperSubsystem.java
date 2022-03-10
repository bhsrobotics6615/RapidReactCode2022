// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallPickerUpperSubsystem extends SubsystemBase {
  /** Creates a new LoaderSubsystem. */
  // TODO: Get rid of this subsystem I suppose
  
  WPI_TalonSRX loader = new WPI_TalonSRX(Constants.PICKER_UPPER);

  public void pickUpTheBall() {

    loader.set(0.25);

  }

  public void stopBPU() {

    loader.stopMotor();
    
  }

}
