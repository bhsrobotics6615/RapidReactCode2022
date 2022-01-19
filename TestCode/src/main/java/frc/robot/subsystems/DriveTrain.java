// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.MoveTheRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {}
  public Command moveTheRobot = new MoveTheRobot();

  TalonSRX motorLeftFront = new TalonSRX(Constants.MOTOR_LEFT_FRONT);
  TalonSRX motorLeftRear = new TalonSRX(Constants.MOTOR_LEFT_REAR);
  TalonSRX motorRightFront = new TalonSRX(Constants.MOTOR_RIGHT_FRONT);
  TalonSRX motorRightRear = new TalonSRX(Constants.MOTOR_RIGHT_REAR);

  public void setLeftMotors (double speedInput) {
    motorLeftFront.set(ControlMode.PercentOutput, -speedInput);
    motorLeftRear.set(ControlMode.PercentOutput, -speedInput);
  }

  public void setRightMotors (double speedInput) {
    motorRightFront.set(ControlMode.PercentOutput, speedInput);
    motorRightRear.set(ControlMode.PercentOutput, speedInput);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
