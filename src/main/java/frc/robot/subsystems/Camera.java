package frc.robot.subsystems;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
  public Camera() {
    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void initDefaultCommand() {
  }
}