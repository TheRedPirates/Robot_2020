package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

public class SpinRoulette extends Command 
{
    private String gameData;
    private double motorVal; 

    public SpinRoulette(double motorVal)
    {
        requires(Robot.m_RouletteSys);
        this.gameData = DriverStation.getInstance().getGameSpecificMessage();
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
        Robot.m_RouletteSys.Spin(-0.2);
        Robot.m_RouletteSys.emergencyStop();
    }

    @Override
    protected boolean isFinished() 
    {
        return RobotMap.colorSensorString.charAt(0) == 'R';
    }
}