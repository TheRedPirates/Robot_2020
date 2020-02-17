package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class GatherBalls extends Command 
{
    private DigitalInput DI;
    private RobotMap rm;

    public GatherBalls()
    {
        //requires(Robot.m_BallGatherSys);
        //this.DI = new DigitalInput(rm.DIO_A);
    }

    @Override
    public void execute()
    {
        Robot.m_BallGatherSys.Suck(0.9);
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