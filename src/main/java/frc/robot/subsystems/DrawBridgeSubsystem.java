
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
public class DrawBridgeSubsystem extends SubsystemBase {
  /** Creates a new LiftDrawBridgeSubsystem. */
  

   WPI_TalonSRX drawBridge;
  Encoder drawBridgeEncoder;
  public DrawBridgeSubsystem()
  {    
    drawBridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);
    drawBridgeEncoder= new Encoder(0, 1, true, Encoder.EncodingType.k4X);
    
    drawBridge.setInverted(false);
  }
 
  //drawBridge.setSelectedSensorPosition(0, 0, 10);
  //drawBridge.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    
 // public void raise() {

   /// drawBridge.set(0.50);

 // }

  public void lift() {
    
    drawBridge.set(0.50);
  
 }
  public void reverseEncoder(boolean reverse)
  {
    drawBridgeEncoder.setReverseDirection(reverse);
  }
  public void resetEncoder()
  {
    drawBridgeEncoder.reset();
  }
  public void lower()
   {      
      drawBridge.set(-0.50);
   }
  public void stop() {

    drawBridge.set(0);
  }

  public double getRawEncoderValue()
  {
    System.out.println("This is the encoder value " + drawBridgeEncoder.getRaw());
    return drawBridgeEncoder.getRaw();
  }
}



