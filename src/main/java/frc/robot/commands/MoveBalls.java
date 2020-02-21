package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_AssemblyLineSys;;

public class MoveBalls extends Command {
    private boolean toReverse;

    public MoveBalls(boolean toReverse) 
    {
        this.toReverse = toReverse;
        requires(m_AssemblyLineSys);
    }

    @Override
    public void execute()
    {
        if (toReverse)
        {
            m_AssemblyLineSys.MoveAssemblyLine(0.5);
        }
        else
        {
            m_AssemblyLineSys.MoveAssemblyLine(-0.5);
        }
    }

    @Override
    protected void end()
    {
        m_AssemblyLineSys.emergencyStop();
        //System.out.println("finished MoveBalls");
    }

    @Override
    protected boolean isFinished() 
    {
        return false;
    }
    
    @Override
    protected void initialize()
    {
        
        System.out.println("started MoveBallsTimed");
    
    }
}