package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class SpinRoulette extends Command 
{
    private RobotMap rm;
    private double motorVal;

    public SpinRoulette(double motorVal)
    {
        requires(Robot.m_RouletteSys);
        this.motorVal = motorVal;
    }

    @Override
    public void execute()
    {
        Robot.m_RouletteSys.Spin(this.motorVal);
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