package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class DriveAuto extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem drive_subsystem;
    private boolean driveAutoDone = false;
    // private double startTime;
    // private double time;
    private Timer timer;
    // private double endTime;

    
    public DriveAuto(DriveTrainSubsystem driveSubsystem, double seconds) {
        
        drive_subsystem = driveSubsystem;
        timer = new Timer();
        // startTime = Timer.getFPGATimestamp();
        // endTime = startTime + seconds;
        addRequirements(driveSubsystem);
        
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        // time = Timer.getFPGATimestamp();
        timer.start();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
        
        if (timer.get() < 5.0) {

            drive_subsystem.move(-0.3,0,0.0);
        
        } else {

            driveAutoDone = true;

        }
        
    }

    @Override
    public boolean isFinished(){

        return driveAutoDone;

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        timer.stop();
        timer.reset();
        drive_subsystem.stop();

    }

   

}
