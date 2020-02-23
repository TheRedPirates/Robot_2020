package frc.robot.triggers;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Robot.m_AssemblyLineSys;

public class JoystickGatherTrigger extends Trigger 
{
    private JoystickButton gatherButton;

    public JoystickGatherTrigger(JoystickButton gatherButton)
    {
        this.gatherButton = gatherButton;
    }

    @Override
    public boolean get() 
    {
        boolean returnVal = !m_AssemblyLineSys.getIsBusy() && gatherButton.get();
        SmartDashboard.putBoolean("Trigger", returnVal);
        return returnVal;
    }
}