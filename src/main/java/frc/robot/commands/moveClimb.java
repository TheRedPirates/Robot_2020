package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class moveClimb extends Command{
    private int val;
    public moveClimb(int val){
        this.val = val;
        requires(Robot.m_ClimbingSys);
    }
    @Override
    public void execute() {
        // TODO fuck Auto-generated method stub
        if(val == 0){
            Robot.m_ClimbingSys.Climb(0.5);
        }
        else if(val == 1){
            Robot.m_ClimbingSys.Climb(-0.5);
        }
        else if(val == 2){
            Robot.m_ClimbingSys.Climb(0);
        }
    }
    @Override
    protected void end() {
        // TODO fuck Auto-generated method stub
        Robot.m_ClimbingSys.emergencyStop();
    }
    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }


}