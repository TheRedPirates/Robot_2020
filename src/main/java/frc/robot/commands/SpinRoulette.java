package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_RouletteSys;
import static frc.robot.Robot.m_arcadeDriveSys;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

public class SpinRoulette extends Command 
{
    private String gameData;
    private double motorVal; 

    public SpinRoulette(double motorVal)
    {
        requires(m_RouletteSys);
        this.gameData = DriverStation.getInstance().getGameSpecificMessage();
        this.motorVal = motorVal;
    }

    @Override
    public void execute()
    {
        m_RouletteSys.Spin(this.motorVal);
        m_arcadeDriveSys.diffDrive.feed();
        m_arcadeDriveSys.diffDrive.feedWatchdog();
    }

    @Override
    protected void end() 
    {
        //Robot.m_RouletteSys.Spin(-0.2);
        m_RouletteSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return RobotMap.colorSensorString.charAt(0) == 'R';
    }
}