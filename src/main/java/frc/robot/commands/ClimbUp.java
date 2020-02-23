package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_ClimbingSys;

public class ClimbUp extends Command 
{ 
    public ClimbUp()
    {
        requires(m_ClimbingSys);
    }

    @Override
    public void execute()
    {
        m_ClimbingSys.openRacK(0.5);
    }


    @Override
    protected void end() 
    {
        m_ClimbingSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
       return m_ClimbingSys.getMicroSwitch();
    }
}