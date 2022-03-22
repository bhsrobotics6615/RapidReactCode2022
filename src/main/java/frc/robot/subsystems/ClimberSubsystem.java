// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Encoder;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */

  WPI_TalonSRX back_climber = new WPI_TalonSRX(Constants.BACK_CLIMBER);
  WPI_TalonSRX front_climber_right = new WPI_TalonSRX(Constants.FRONT_CLIMBER_1);
  WPI_TalonSRX front_climber_left = new WPI_TalonSRX(Constants.FRONT_CLIMBER_2);
  
  DigitalInput back_climb_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_TOP_LIMIT);
  DigitalInput front_climb_left_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_1_LIMIT_SWITCH);
  DigitalInput front_climb_right_limit_Switch = new DigitalInput(Constants.FRONT_CLIMB_2_LIMIT_SWITCH);

  public boolean backClimberStatus = false;
  public boolean frontLeftClimberPosition = false;
  public boolean frontRightClimberPosition = false;

 public void front_climber_retract() {
   /* int step = 0;

   if(front_climb_right_limit_Switch.get() && step == 0){
    front_climber_right.set(-.4);
    front_climber_left.set(-.65);
    step++;
   } 
   
   else if(!front_climb_right_limit_Switch.get() && step == 1){
    front_climber_right.set(-.4);
    front_climber_left.set(-.65);
    step++;
   } 
   
   else if(!front_climb_right_limit_Switch.get() && step == 2){
    front_climber_right.set(0);
    front_climber_left.set(0);
    step++;
   } 
   
   else {
    front_climber_right.set(0);
    front_climber_left.set(0);
   }

   System.out.print(step);
*/
    System.out.println("RETRACTING!");
    front_climber_right.set(-.4);
    System.out.println(front_climber_right.get());
    front_climber_left.set(-.4);
    System.out.println(front_climber_left.get());

  }
  
  public void front_climber_extend(){

   /*  int step = 0;

    if(front_climb_left_limit_Switch.get() && step == 0){
     front_climber_right.set(.4);
     front_climber_left.set(.65);
     step++;
     System.out.print(step);
    } 
    
    else if(!front_climb_left_limit_Switch.get() && step == 1){
     front_climber_right.set(.4);
     front_climber_left.set(.65);
     step++;
     System.out.print(step);
    } 
    
    else if(!front_climb_left_limit_Switch.get() && step == 2){
     front_climber_right.set(0);
     front_climber_left.set(0);
     step++;
     System.out.print(step);
    } 
    
    else {
     front_climber_right.set(0);
     front_climber_left.set(0);
    } */

while (front_climb_left_limit_Switch.get()){
      front_climber_right.set(.1);
    front_climber_left.set(.1);
}
Shuffleboard.getTab("Front Left DI Sensor")
  .add(front_climb_left_limit_Switch);

  }

  public void front_climber_stop(){
    front_climber_right.set(0);
    front_climber_left.set(0);

  }

  public void back_climber_extend() {
    back_climber.set(-.3);
  }

  public void back_climber_retract() {
    back_climber.set(1);
  }

  public void back_climber_off() {
    back_climber.set(0);
  }
}

  /*public void frontClimberLower(){p
        if (front_climb_2_limit_Switch.get() == true && frontRightClimberPosition == true);
        
            // We are going down and bottom limit is tripped so stop
            climber_2.set(-o.75);
            // We are going down but bottom limit is not tripped so go at commanded speed
            climber.set-0.75);
        }*/
    
  
 /*public boolean front_extend() {
      if (front_climb_top_limit_Switch.get() frontClimberPosition) {
        // We are going up and top limit is tripped so stop
        front_climber_1.set(0);
        front_climber_2.set(0);
        return frontClimberPosition = true;
    //  } else {
        // We are going up but top limit is not tripped so go at commanded speed
        front_climber_1.set(0.75);
        front_climber_2.set(0.75);
         return frontClimberStatus = false;
      }
  }

 // public void frontLower() {

    if (front_climb__limit_Switch.get()) {
      // We are going down and bottom limit is tripped so stop
      front_climber_1.set(0);
      front_climber_2.set(0);
  } else {
      // We are going down but bottom limit is not tripped so go at commanded speed
      front_climber_1.set(-0.75);
      front_climber_2.set(-0.75);
    }
  }*/

