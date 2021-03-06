package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_ClimbingSys;

public class CloseRack extends Command 
{ 
    public CloseRack()
    {
        requires(m_ClimbingSys);
    }

    @Override
    public void execute()
    {
        m_ClimbingSys.closeRack(0.5);
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