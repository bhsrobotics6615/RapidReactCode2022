// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallPickerUpper extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public BallPickerUpper() {}

  public PWMTalonSRX pickerUpperMotor;

  public void pickUpTheBall() {
    pickerUpperMotor.set(Constants.PICK_UP_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    
    // Need to set lift level for wheels
    
  }
}
