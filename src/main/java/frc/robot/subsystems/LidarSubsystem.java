// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LidarSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  double opposite;
  double distance;
  double theta;

  public LidarSubsystem() {

    opposite = Constants.HEIGHT_OF_HUB - Constants.HEIGHT_OF_CAMERA;
    theta = 0;
    
  }

  // Finds distance from limelight to retro-reflective tape
  public double findDistance(double angleOfError) {

    theta = Constants.LIMELIGHT_MOUNTING_ANGLE + angleOfError;
    distance = opposite / Math.sin(theta);
    return distance;

  }

  // Calculates power for distance
  public double findPower(double distance) {
    
    return 0.0;
    
  }

}