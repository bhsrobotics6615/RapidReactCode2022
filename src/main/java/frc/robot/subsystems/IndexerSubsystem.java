// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {
  /** Creates a new IteratorSubsystem. */

    WPI_TalonSRX indexer = new WPI_TalonSRX(Constants.INDEXER);
    
  public void load() {

    indexer.set(0.5);

  }

  // Think about renaming this function
  public void stop() {

    indexer.set(0);

  }


  
}
