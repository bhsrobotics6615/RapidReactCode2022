package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The Variables class provides a convenient place for teams to hold robot-wide numerical or boolean
 * variables. This class should not be used for any other purpose. All variables should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * variables are needed, to reduce verbosity.
 */

public class Variables {

    public static double targetDistance = 0;
    public static double launcherSpeed = 1;
    public static boolean reachedClimbax = false;
    // public static double theta = 0; // Theta for launcher
    // public static double thetaDegrees = 3.1415 * theta;
    public static double scoreDistance;

    public static DigitalInput back_climb_limit_Switch = new DigitalInput(Constants.BACK_CLIMB_LIMIT);
    public static DigitalInput front_climb_right_limit_switch = new DigitalInput(Constants.FRONT_CLIMB_1_LIMIT_SWITCH);
    public static DigitalInput front_climb_left_limit_switch = new DigitalInput(Constants.FRONT_CLIMB_2_LIMIT_SWITCH);

    // public static int loaderSpeed = 1;
}
