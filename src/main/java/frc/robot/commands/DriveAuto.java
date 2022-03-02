package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
// import frc.robot.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class DriveAuto extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem drive_subsystem;
    private boolean driveAutoDone = false;
    private double distance;
    
    
    
    public DriveAuto(DriveTrainSubsystem driveSubsystem, double distance) {
        drive_subsystem = driveSubsystem;
        this.distance = distance; //this is the distance the robot will travel to
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
       drive_subsystem.encoderOn();
       drive_subsystem.encoderZero();

        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
       while(drive_subsystem.getDistance() < distance)
       {
        drive_subsystem.moveAuto(0, -0.4, 0);
       }
       driveAutoDone = true;
    }

    @Override
    public boolean isFinished(){

        return driveAutoDone;

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive_subsystem.stop();
    }

   

}
