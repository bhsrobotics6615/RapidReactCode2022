package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveAuto extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem drive_subsystem;
    private boolean driveAutoDone = false;
  
    
    public DriveAuto(DriveTrainSubsystem driveSubsystem) {
        
        drive_subsystem = driveSubsystem;
       
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {


    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {

        
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
