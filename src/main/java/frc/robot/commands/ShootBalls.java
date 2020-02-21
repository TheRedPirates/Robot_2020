package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class ShootBalls extends Command 
{
    public ShootBalls()
    {
        requires(Robot.m_BallShootSys);
        requires(Robot.m_AssemblyLineSys);    
    }

    @Override
    public void execute()
    {
        Robot.m_AssemblyLineSys.MoveAssemblyLine(0.9); // CR 11
        Robot.m_BallShootSys.Shoot(0.9);
    }

    @Override
    protected void end()
    {
        Robot.m_AssemblyLineSys.emergencyStop();
        Robot.m_BallShootSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return false;
    }
}