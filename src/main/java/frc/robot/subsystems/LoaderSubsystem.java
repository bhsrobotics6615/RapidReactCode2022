// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LoaderSubsystem extends SubsystemBase {
  /** Creates a new LoaderSubsystem. */
  
  WPI_TalonSRX loader = new WPI_TalonSRX(Constants.LOADER);
  WPI_TalonSRX loaderLifter = new WPI_TalonSRX(Constants.LOADER_LIFTER);

  public void load() {
    loader.set(1);
  }

  // Think about renaming this function
  public void stop() {
    loader.set(0);
  }

  public void liftTheLoader() {
    loaderLifter.set(1);
  }

  public void stopLiftingLoader() {
    loaderLifter.set(0);
  }

  public void lowerTheLoader() {
    loaderLifter.set(-1);
  }
}
