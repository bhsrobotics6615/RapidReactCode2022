// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Encoder;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */

  WPI_TalonSRX back_climber = new WPI_TalonSRX(Constants.BACK_CLIMBER);
  WPI_TalonSRX front_climber_1 = new WPI_TalonSRX(Constants.FRONT_CLIMBER_1);
  WPI_TalonSRX front_climber_2 = new WPI_TalonSRX(Constants.FRONT_CLIMBER_2);
  
  DigitalInput back_climb_top_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_TOP_LIMIT);
  DigitalInput back_climb_bottom_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_BOTTOM_LIMIT);
  DigitalInput front_climb_top_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_TOP_LIMIT_SWITCH);
  DigitalInput front_climb_bottom_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_BOTTOM_LIMIT_SWITCH);


 public void back_climber_lift(double speed) {
        if (back_climb_top_limit_Switch.get()) {
            // We are going up and top limit is tripped so stop
            back_climber.set(0);
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            back_climber.set(0.75);
        }
      }

  public void backClimberLower(double speed){
        if (back_climb_bottom_limit_Switch.get()) {
            // We are going down and bottom limit is tripped so stop
            back_climber.set(0);
        } else {
            // We are going down but bottom limit is not tripped so go at commanded speed
            back_climber.set(-0.25);
        }
    }
  
  public void front_extend() {
      if (front_climb_top_limit_Switch.get()) {
        // We are going up and top limit is tripped so stop
        front_climber_1.set(0);
        front_climber_2.set(0);
      } else {
        // We are going up but top limit is not tripped so go at commanded speed
        front_climber_1.set(0.75);
        front_climber_2.set(0.75);
      }
  }

  public void frontLower() {

    if (front_climb_bottom_limit_Switch.get()) {
      // We are going down and bottom limit is tripped so stop
      front_climber_1.set(0);
      front_climber_2.set(0);
  } else {
      // We are going down but bottom limit is not tripped so go at commanded speed
      front_climber_1.set(-0.75);
      front_climber_2.set(-0.75);
    }
  }
}
