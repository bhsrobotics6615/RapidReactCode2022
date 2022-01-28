package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LidarSubsystem;

public class DriveAuto extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem drive_subsystem;
    private final LidarSubsystem lidar_subsystem;
    private boolean areaFound = false;

    public DriveAuto(DriveTrainSubsystem driveSubsystem, LidarSubsystem lidarSubsystem) {
        
        drive_subsystem  = driveSubsystem;
        lidar_subsystem = lidarSubsystem;
        addRequirements(driveSubsystem);
        addRequirements(lidarSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
     
        while (Limelight.getArea() != 0 && Limelight.getX() != 0) 
        {

            if (-10 > Limelight.getX() || Limelight.getX() > 10)
             {
      
              drive_subsystem.Move(0.2, 0.2, 0.0);
      
             }
      

        }
        areaFound = true;   
    }

    @Override
    public boolean isFinished(){
        return areaFound;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive_subsystem.Stop();
    }

   

}
