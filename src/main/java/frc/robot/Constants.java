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

    // Controller Ports
    public static final int JOYSTICK = 0;
    public static final int XBOX = 1;

    // Heights
    public static final int HEIGHT_OF_HUB = 0;
    public static final int HEIGHT_OF_CAMERA = 0;
  
    // Angles
    public static final double LIMELIGHT_MOUNTING_ANGLE = 45;

    // Xbox Controller Buttons
    public static final int RUN_LAUNCHER = XboxController.Button.kA.value;
    public static final int RUN_INDEXER = XboxController.Button.kX.value;
    // Ball Picker Upper (BPU)
    public static final int RUN_BPU = XboxController.Button.kB.value;
    public static final int RAISE_BPU = XboxController.Button.kBack.value;
    public static final int LOWER_Drawbridge = XboxController.Button.kStart.value;

    // Logitech Joystick Buttons
    public static final int RUN_LIDAR = 2;

    // Other (other constants with no category)
    public static final double PICK_UP_SPEED = 0;

    // Speed Conversion
    public static final double SPEED_CONVERT = 6.23;

    //Encoder Math Counts to Feet
    public static final double kCOUNTS_FEET = (1/64)*(10.71/1)*(6*Math.PI) *
(1/12);
}
