package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_ClimbingSys;

public class Climb extends Command 
{ 
    public Climb()
    {
        requires(m_ClimbingSys);
    }

    @Override
    public void execute()
    {
        m_ClimbingSys.climb(0.9);
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