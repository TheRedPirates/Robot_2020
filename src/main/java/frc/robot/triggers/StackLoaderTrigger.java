package frc.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Robot.m_AssemblyLineSys;

public class StackLoaderTrigger extends Trigger 
{
    @Override
    public boolean get() 
    {
        boolean value =  m_AssemblyLineSys.isStackLoaderActive();
        SmartDashboard.putBoolean("switch", value);
        return value;
    }
}