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
  WPI_TalonSRX drawBridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);
//Encoder drawBridgeEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
  
    
 
  public void lift() {
    
    drawBridge.set(0.50);

  }

  public void lower() {
    
   
    drawBridge.set(0.50);

  }

  public void stop() {

    drawBridge.stopMotor();

  }

  /*public double getRawEncoderValue() {
    
    return drawBridgeEncoder.getRaw();
  }*/

}
