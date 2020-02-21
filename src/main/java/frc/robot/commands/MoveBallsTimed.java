package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import static frc.robot.Robot.m_BallGatherSys;
import static frc.robot.Robot.m_AssemblyLineSys;


public class MoveBallsTimed extends Command {
    private boolean isFin = false;
    public MoveBallsTimed() 
    {
        requires(m_AssemblyLineSys);
    }

    @Override
    public void execute()
    {
        RobotMap.ballCount += 1;

        try{
            if (true)
            {
                //RobotMap.ballCount != 5
                m_AssemblyLineSys.MoveAssemblyLine(0.9);
                m_BallGatherSys.Suck(0.6);
                Thread.sleep(400);
                m_BallGatherSys.Suck(0);
                Thread.sleep(450
                );
            } else
            {
                RobotMap.ballCount = 0;
            }
           
            this.isFin = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @Override
    protected void end()
    {
        RobotMap.ballCount = 0;
        m_AssemblyLineSys.emergencyStop();
        System.out.println("finished MoveBallsTimed");
    }

    @Override
    protected boolean isFinished() 
    {

        return isFin;
    }
    
    @Override
    protected void initialize()
    {
        System.out.println("started MoveBallsTimed");
        setTimeout(2);
    }
}