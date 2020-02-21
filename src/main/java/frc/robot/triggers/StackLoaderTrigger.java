package frc.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import static frc.robot.Robot.m_AssemblyLineSys;

public class StackLoaderTrigger extends Trigger {

    @Override
    public boolean get() 
    {
       return m_AssemblyLineSys.isStackLoaderActive();
    }
    
}