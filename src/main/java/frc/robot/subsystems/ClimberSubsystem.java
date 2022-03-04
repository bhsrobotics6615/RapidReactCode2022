// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */

  WPI_TalonSRX back_climber = new WPI_TalonSRX(Constants.BACK_CLIMBER);
  WPI_TalonSRX middle_climbers = new WPI_TalonSRX(Constants.MIDDLE_CLIMBERS);
  WPI_TalonSRX draw_bridge_climbers = new WPI_TalonSRX(Constants.DRAW_BRIDGE_CLIMBERS);
 
  //public void back_extend() {
   // back_climber.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
     //backClimberPosition = back_climber.get
   // while(backClimberPosition < Constants.EXTENDED_POSITION ){
   //    back_climber.set(0.25);
    //}
    
    // speed not final }

  

  public void back_reset() {

    back_climber.stopMotor(); // have to set up encoders

  }

  public void back_lift() {

    back_climber.set(-0.25);

  }
  
  public void middle_extend() {

    middle_climbers.set(0.25);

  }

  public void middle_reset() {

    middle_climbers.stopMotor();

  }

  public void middle_lift() {

    middle_climbers.set(-0.25);

  }
  
  public void draw_bridge_extend() {

    draw_bridge_climbers.set(0.25);

  }

  public void draw_bridge_reset() {

    draw_bridge_climbers.stopMotor();

  }

  public void draw_bridge_lift() {

    draw_bridge_climbers.set(-0.25);

  }

}
