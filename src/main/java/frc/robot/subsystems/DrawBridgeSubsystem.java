// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrawBridgeSubsystem extends SubsystemBase {
  /** Creates a new LiftDrawBridgeSubsystem. */

    WPI_TalonSRX draw_Bridge; 
    public boolean bpuStatus = false;

  public DrawBridgeSubsystem()
  {
    draw_Bridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);
    draw_Bridge.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    
    draw_Bridge.setSensorPhase(false);

    draw_Bridge.setSelectedSensorPosition(0, 0, 10);
    draw_Bridge.setInverted(false);

  }

  

  public boolean lift() {
    // TODO: Create a boolean that checks whether the drawbridge is up or down
    // TODO: Set draw bridge functions to be dependent on encoder positions
    draw_Bridge.set(0.5);
    return bpuStatus = true;
  }

  public void lower() {

    draw_Bridge.set(-0.5);

  }

  public void stop() {

    draw_Bridge.stopMotor();

  }
  public double getEncoderValue() {
    return draw_Bridge.getSelectedSensorPosition();
  }

  
  
}
