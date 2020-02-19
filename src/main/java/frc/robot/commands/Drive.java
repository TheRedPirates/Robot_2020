package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command
{  
    public Drive() 
    {
        requires(Robot.m_arcadeDriveSys);
    }

    @Override
    protected void execute() 
    {
        Robot.m_arcadeDriveSys.Drive(Robot.m_oi.driverLeftJoystick);
        Robot.m_arcadeDriveSys.diffDrive.feedWatchdog();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
