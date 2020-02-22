package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_arcadeDriveSys;

public class Drive extends Command
{  
    public Drive() 
    {
        requires(m_arcadeDriveSys);
    }

    @Override
    protected void execute() 
    {
        m_arcadeDriveSys.Drive();
        m_arcadeDriveSys.diffDrive.feedWatchdog();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
