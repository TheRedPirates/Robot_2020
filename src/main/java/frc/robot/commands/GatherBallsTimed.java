package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_AssemblyLineSys;
import static frc.robot.Robot.m_BallGatherSys;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class GatherBallsTimed extends Command 
{
    public GatherBallsTimed()
    {
        requires(m_BallGatherSys);
    }

    @Override
    public void execute()
    {
       m_BallGatherSys.Suck(0.9);
       m_AssemblyLineSys.MoveAssemblyLine(0.9);
    }

    @Override
    protected void end()
    {
        m_BallGatherSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return isTimedOut();
    }

    @Override
    protected void initialize()
    {
        
        System.out.println("started MoveBallsTimed");
        setTimeout(0.75);
    }
}