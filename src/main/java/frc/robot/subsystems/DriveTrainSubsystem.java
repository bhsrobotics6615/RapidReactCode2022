// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrainSubsystem extends SubsystemBase {

    // public PWMTalonSRX frontLeft, backLeft, frontRight, backRight;
    public MecanumDrive drive;
    private WPI_TalonSRX frontRight;
    private WPI_TalonSRX backRight;
    private WPI_TalonSRX backLeft;
    private WPI_TalonSRX frontLeft;

//             forwardSpeed = Math.pow(forwardSpeed, 2);

        // Drive control motors
        public DriveTrainSubsystem(){

            // Drive control motors
            frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
            backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
            backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
            frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7
            
            //Encoders
            backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
            backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
            frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
            frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);

            frontLeft.setSelectedSensorPosition(0,0,10);
            frontRight.setSelectedSensorPosition(0,0,10);
          //  frontRight.setInverted(true);
          //  backRight.setInverted(true);
            
            drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    
        }
        
//         }

   
    public void encoderOn()
    {
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);

        //frontLeft.setSensorPhase(false);
        //frontRight.setSensorPhase(true);

        frontLeft.setSelectedSensorPosition(0,0,10);
        frontRight.setSelectedSensorPosition(0,0,10);

        //frontLeft.setInverted(false);
        //frontRight.setInverted(true);
        //backLeft.follow(frontLeft);
        //backRight.follow(frontRight);
    }

    public void encoderZero()
    {
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontLeft.setSelectedSensorPosition(0,0,10);
        frontRight.setSelectedSensorPosition(0,0,10);   
    }
    public double getDistance()
    { 
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        System.out.println("this code ran hehe!");
        double leftPosition = (frontLeft.getSelectedSensorPosition()/6900);
        double rightPosition = (frontRight.getSelectedSensorPosition()/6900);
        double distance = Math.abs((leftPosition + rightPosition)/2);
        System.out.println(distance);
        return distance;
    }

    
 
    public void move(double forwardSpeed, double horizontalSpeed, double rotationRate) { // Move the robot in a specified direction

        if (horizontalSpeed > 0) {
            
             horizontalSpeed = Math.pow(horizontalSpeed, 2);

         } else if (horizontalSpeed < 0) {

             horizontalSpeed = -Math.pow(horizontalSpeed, 2);

         }

         if (rotationRate > 0) {

             rotationRate = Math.pow(rotationRate, 2);

         } else if (rotationRate < 0) {

             rotationRate = -Math.pow(rotationRate, 2);
            
         }

        drive.driveCartesian(forwardSpeed, horizontalSpeed, rotationRate);

    }
     
    public void driveDistance(double distance) {

    }

    public void stop() { // Stop motor movement

       drive.driveCartesian(0, 0, 0);
        
    }
}
