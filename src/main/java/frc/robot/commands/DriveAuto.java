package frc.robot.commands;

// import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
// import frc.robot.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class DriveAuto extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveTrainSubsystem drive_subsystem;
    private boolean driveAutoDone = false;
    private double distance;
    private double errorSum = 0;
    private double lastTimestamp = 0;
    private double setpoint = (8) + 2;
    private double error;
    private double kp = 0.25; //0.25
    private double ki = 0.05;
    private double outputspeed; 
    
    public DriveAuto(DriveTrainSubsystem driveSubsystem/*double setpoint*/) {
        drive_subsystem = driveSubsystem;
        //this.setpoint = setpoint; //this is the distance the robot will travel to
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
       errorSum = 0;
       lastTimestamp = Timer.getFPGATimestamp();
       drive_subsystem.encoderOnBackwards();
       drive_subsystem.encoderZero();
    
        
    }
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
   
        
       
        while(error != 0)
        {

          System.out.println(distance);
          //distance = Math.abs(distance);
          error = (setpoint) - distance;
          double dt = Timer.getFPGATimestamp() - lastTimestamp;
          errorSum += error * dt;
          outputspeed = kp * error  /* + ki * errorSum*/;
          drive_subsystem.move(-outputspeed, 0,0);
    
          lastTimestamp = Timer.getFPGATimestamp();
        }
      
        
        driveAutoDone = true;
    }

    @Override
    public boolean isFinished() {

        return driveAutoDone;

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        drive_subsystem.stop();

    }

}
