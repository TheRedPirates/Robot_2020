package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class CameraSys extends Subsystem 
{
    public CameraSys() 
    {
        CameraServer.getInstance().startAutomaticCapture(RobotMap.SUCK_CAMERA_PORT);
        CameraServer.getInstance().startAutomaticCapture(RobotMap.FIELD_CAMERA_PORT);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}