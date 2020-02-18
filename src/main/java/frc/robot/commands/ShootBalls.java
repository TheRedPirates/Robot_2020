package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class ShootBalls extends Command 
{
    private DigitalInput DI; // CR 7
    private RobotMap rm; // CR 8

    public ShootBalls()
    {
        requires(Robot.m_BallGatherSys);
        this.DI = new DigitalInput(rm.DIO_A);
    }

    @Override
    public void execute()
    {
        Robot.m_BallGatherSys.Shoot(0.9, 0.9); // CR 11
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