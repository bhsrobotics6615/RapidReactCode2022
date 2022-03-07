// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrawBridgeSubsystem extends SubsystemBase {
  /** Creates a new LiftDrawBridgeSubsystem. */
  
  WPI_TalonSRX drawBridge; 
  Encoder drawBridgeEncoder;
  public DrawBridgeSubsystem()
  {
    drawBridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);
    drawBridgeEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    drawBridge.setInverted(false);

  }

  public void setEncoderInverted()
  {
    drawBridgeEncoder.setReverseDirection(true);
  }
  public void resetEncoder()
  {
    drawBridgeEncoder.reset();
  }

  public double getRawEncoderCount()
  {
    return drawBridgeEncoder.getRaw();
  }
 
  public void lift() {

    drawBridge.set(0.50);

  }

  public void lower() {

    drawBridge.set(-0.50);

  }

  public void liftAuto(double power)
  {
    drawBridge.set(power);
  }

  public void lowerAuto(double power)
  {
    drawBridge.set(power);
  }
  public void stop() {

    drawBridge.stopMotor();

  }
  
}
