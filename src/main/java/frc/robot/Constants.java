// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p> It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Talon SRX Ports
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 5;

    public static final int BACK_LEFT_MOTOR = 4;
    public static final int FRONT_LEFT_MOTOR = 7;
    public static final int LAUNCHER = 6;
    public static final int PICKER_UPPER = 1;
    public static final int INDEXER = 10;
    public static final int DRAW_BRIDGE = 11;
    public static final int BACK_CLIMBER = 420;
    public static final int FRONT_CLIMBER_1 = 0;
    public static final int FRONT_CLIMBER_2 = 0;

    
    // Controller Ports
    // public static final int JOYSTICK = 0;
    public static final int DRIVE_CONTROLLER = 0;
    public static final int XBOX = 1;

    // Heights
    public static final double HEIGHT_OF_HUB = 2.6416;
    public static final double HEIGHT_OF_CAMERA = 0.7493;
    public static final double HEIGHT_OF_LAUNCHER = 0;

    // Limelight
    public static final double LIMELIGHT_X_PRECISION = 0.15; // Precision expected looking on the x-axis
    public static final double LIMELIGHT_TARGET_X = 0; // Target value on the x-axis
    public static final double LIMELIGHT_Y_PRECISION = 0.2; // Precision expected looking on the y-axis
    public static final double LIMELIGHT_TARGET_Y = -3.5; // Target value on the y-axis

    // Search
    public static final double SEARCH_ROTATION_SPEED = 0.3;

    // Align
    public static final double ALIGN_ROTATION_SPEED = 0.15;
    public static final double ALIGN_MOVEMENT_SPEED = 0.2;

    // Angles
    public static final double LIMELIGHT_MOUNTING_ANGLE = 60;
    public static final double LAUNCHER_ANGLE = 60;

    // Xbox Controller Buttons
    public static final int RUN_LAUNCHER = XboxController.Button.kA.value;
    public static final int RUN_INDEXER = XboxController.Button.kX.value;
    public static final int CHOKING = XboxController.Button.kRightBumper.value;
    public static final int AUTO_LAUNCH = XboxController.Button.kY.value;
    // Ball Picker Upper (BPU)
    public static final int RUN_BPU = XboxController.Button.kB.value;
    public static final int LIFT_BPU = XboxController.Button.kBack.value;
    public static final int LOWER_BPU = XboxController.Button.kStart.value;
    public static final int AUTO_RAISE = XboxController.Button.kA.value;
    public static final int AUTO_LOWER = XboxController.Button.kB.value;

    public static final int BALL_DETECTOR = 4;
    public static final int BALL_ENTERED = 5;

    // Logitech Joystick Buttons
    public static final int RUN_LIDAR = 10;

    // Other (other constants with no category)
    public static final double PICK_UP_SPEED = 0;
    public static final double AUTOTIME = 0;
	public static final int EXTENDED_POSITION = 0;

    // Launcher Run
    public static final double LAUNCH_RUN_TIME = 3;
    public static final double INDEX_TIME = 2;

    // limit switches
    public static final int BACK_CLIMB_TOP_LIMIT = 0;
    public static final int BACK_CLIMB_BOTTOM_LIMIT = 0;
   
    public static final int FRONT_CLIMB_2_LIMIT_SWITCH = 7;
    public static final int FRONT_CLIMB_1_LIMIT_SWITCH = 8;

    // Speed Conversion
    public static final double SPEED_CONVERT = 6.23;

    //Encoder Math Counts to Feet
    public static final double kTICKS_FEET = (1/6900);
    public static final int FRONT_CLIMB = 0;
    


}
