
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrawBridgeSubsystem extends SubsystemBase {
  /** Creates a new LiftDrawBridgeSubsystem. */
  WPI_TalonSRX drawBridge = new WPI_TalonSRX(Constants.DRAW_BRIDGE);
  Encoder drawBridgeEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
  
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

 public void resets(){
   
   drawBridgeEncoder.reset();
 }

  public int getRawEncoderValue() {
    //POSITIVE AS U GO UP 
    return drawBridgeEncoder.getRaw();

  }

}



