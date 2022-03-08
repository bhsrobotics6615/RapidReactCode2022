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
  WPI_TalonSRX front_climbers = new WPI_TalonSRX(Constants.FRONT_CLIMBERS);
  DigitalInput back_climb_top_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_TOP_LIMIT);
  DigitalInput back_climb_bottom_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_BOTTOM_LIMIT);


 public void back_climber(double speed) {
    if (speed > 0) {
        if (back_climb_top_limit_Switch.get()) {
            // We are going up and top limit is tripped so stop
            back_climber.set(0);
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            back_climber.set(0.25);
        }
    } else {
        if (back_climb_bottom_limit_Switch.get()) {
            // We are going down and bottom limit is tripped so stop
            back_climber.set(0);
        } else {
            // We are going down but bottom limit is not tripped so go at commanded speed
            back_climber.set(-0.25);
        }
    }
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
