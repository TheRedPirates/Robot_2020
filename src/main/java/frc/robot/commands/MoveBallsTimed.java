package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_BallGatherSys;
import static frc.robot.Robot.m_AssemblyLineSys;


public class MoveBallsTimed extends Command 
{    
    public MoveBallsTimed() 
    {
        requires(m_AssemblyLineSys);
    }

    @Override
    public void execute()
    {
        m_AssemblyLineSys.MoveAssemblyLine(0.9);
        m_BallGatherSys.Suck(0.6);
    }

    @Override
    protected void end()
    {
        m_AssemblyLineSys.emergencyStop();
        m_BallGatherSys.emergencyStop();

        m_AssemblyLineSys.unlock();
    }

    @Override
    protected boolean isFinished() 
    {
        return isTimedOut();
    }
    
    @Override
    protected void initialize()
    {
        m_AssemblyLineSys.lock();
        setTimeout(0.850);
    }
}