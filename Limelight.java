// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/** Add your docs here. */
public class Limelight {

    private static NetworkTable limelight_table = NetworkTableInstance.getDefault().getTable("limelight");
    private static NetworkTableEntry tx = limelight_table.getEntry("tx");
    private static NetworkTableEntry ty = limelight_table.getEntry("ty");
    private static NetworkTableEntry ta = limelight_table.getEntry("ta");

    public static double getX() {

        return tx.getDouble(0.0);

    }

    public static double getY() {

        return ty.getDouble(0.0);

    }

    public static double getArea() {

        return ta.getDouble(0.0);

    }

}
