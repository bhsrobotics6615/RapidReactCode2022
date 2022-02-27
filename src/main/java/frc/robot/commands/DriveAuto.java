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
   
    final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR); // 2022 2
    final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR); // 2022 5
    final WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR); // 2022 4
    final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR); // 2022 7
    
    
    public DriveAuto(DriveTrainSubsystem driveSubsystem) {
        drive_subsystem = driveSubsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
       

        frontLeft.setInverted(true);
        frontRight.setInverted(false);
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);

        frontLeft.setSensorPhase(false);
        frontRight.setSensorPhase(true);

        frontLeft.setSelectedSensorPosition(0,0,10);
        frontRight.setSelectedSensorPosition(0,0,10);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
        final double kCOUNTS_FEET = (1/64)*(10.71/1)*(6*Math.PI) *
        (1/12);
        double leftPosition = frontLeft.getSelectedSensorPosition() * kCOUNTS_FEET;
        double rightPosition = frontRight.getSelectedSensorPosition() * kCOUNTS_FEET;
        double distance = (leftPosition + rightPosition)/2;

        while(distance < 5)
        {
            drive_subsystem.moveAuto(0.5, 0, 0);
        }
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
