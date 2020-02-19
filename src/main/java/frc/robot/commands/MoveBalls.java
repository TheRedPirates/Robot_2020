package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class MoveBalls extends Command 
{
    


    public MoveBalls()
    {
        requires(Robot.m_BallGatherSys);
        
    }

    @Override
    public void execute()
    {
        Robot.m_BallGatherSys.MoveAssemblyLine(0.9); // CR 11
    }

    @Override
    protected void end()
    {
        Robot.m_BallGatherSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return false;
    }
}