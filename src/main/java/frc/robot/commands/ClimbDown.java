package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_ClimbingSys;

public class ClimbDown extends Command 
{ 
    public ClimbDown()
    {
        requires(m_ClimbingSys);
    }

    @Override
    public void execute()
    {
        m_ClimbingSys.closeRack(0.9);
    }

    @Override
    protected void end() 
    {
        m_ClimbingSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return false;
    }
}