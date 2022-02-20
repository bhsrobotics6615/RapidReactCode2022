// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrawBridgeSubsystem extends SubsystemBase {
  /** Creates a new LiftDrawBridgeSubsystem. */
  
  WPI_TalonSRX draw_bridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);

  public void lift() {

    draw_bridge.set(0.1);

  }

  public void lower() {

    draw_bridge.set(-0.1);

  }

  public void stop() {

    draw_bridge.set(0);

  }

  
}
