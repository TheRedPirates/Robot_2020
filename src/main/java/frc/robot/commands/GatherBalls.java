package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class GatherBalls extends Command 
{
    private DigitalInput DigitalInput; //cr 12

    public GatherBalls()
    {
        requires(Robot.m_BallGatherSys);
        this.DigitalInput = new DigitalInput(RobotMap.DIO_A);
    }

    @Override
    public void execute()
    {
       if (this.DigitalInput.get())
       {
           
       }

        Robot.m_BallGatherSys.Suck((RobotMap.SUCK_TIME));
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