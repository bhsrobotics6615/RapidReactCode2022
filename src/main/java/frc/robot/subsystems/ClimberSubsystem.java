// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import frc.robot.Variables;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Encoder;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */

  WPI_TalonSRX back_climber = new WPI_TalonSRX(Constants.BACK_CLIMBER);
  WPI_TalonSRX front_climbers = new WPI_TalonSRX(Constants.FRONT_CLIMBERS);
 
  public void back_extend() {
   
    while(!Variables.reachedClimbax){

      back_climber.set(0.25);
    
    }

  }

  public void back_reset() {

    back_climber.stopMotor(); // have to set up encoders

  }

  public void back_lift() {

    back_climber.set(-0.25);

  }
  
  public void front_extend() {

    front_climbers.set(0.25);

  }

  public void front_reset() {

    front_climbers.stopMotor();

  }

  public void front_lift() {

    front_climbers.set(-0.25);

  }
}
