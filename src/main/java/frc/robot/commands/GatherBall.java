package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_AssemblyLineSys;
import static frc.robot.Robot.m_BallGatherSys;
import frc.robot.RobotMap;
import frc.robot.triggers.StackLoaderTrigger;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class GatherBall extends Command 
{
    public GatherBall()
    {
        requires(m_BallGatherSys);
    }

    @Override
    public void execute()
    {
        m_BallGatherSys.Suck(0.6);
    }

    @Override
    protected void end()
    {
        m_BallGatherSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
       return m_AssemblyLineSys.isStackLoaderActive();
    }
}