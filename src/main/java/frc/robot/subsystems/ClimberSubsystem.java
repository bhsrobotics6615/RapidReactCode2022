// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.Variables;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import edu.wpi.first.wpilibj.Encoder;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */

  WPI_TalonSRX back_climber = new WPI_TalonSRX(Constants.BACK_CLIMBER);
  WPI_TalonSRX front_climber_right = new WPI_TalonSRX(Constants.FRONT_CLIMBER_1);
  WPI_TalonSRX front_climber_left = new WPI_TalonSRX(Constants.FRONT_CLIMBER_2);
  
  DigitalInput front_climb_right_limit_Switch = Variables.front_climb_right_limit_switch; 
  DigitalInput front_climb_left_limit_Switch = Variables.front_climb_left_limit_switch; 
  DigitalInput back_climb_limit_switch = Variables.back_climb_limit_switch;


  public void front_right_climber_retract() 
  {

    front_climber_right.set(.6);
  }

  public void front_left_climber_retract() 
  {


    front_climber_left.set(.55);

  }
  
  public void front_right_climber_extend()
  {
    front_climber_right.set(-.4);

  }

  public void front_left_climber_extend(){
    front_climber_left.set(-.35);
    
  }

  public void front_right_climber_stop(){

    front_climber_right.stopMotor();
  }
    public void front_left_climber_stop(){
    front_climber_left.stopMotor();

  }
  public void front_climber_stop(){
    front_climber_left.stopMotor();
    front_climber_right.stopMotor();
  }

  public void back_climber_extend() {

    back_climber.set(0.35);

  }

  public void back_climber_retract() {

    back_climber.set(-1);

  }

  public void back_climber_off() {

    back_climber.stopMotor();

  }
}
