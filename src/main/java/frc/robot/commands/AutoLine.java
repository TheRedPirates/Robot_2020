package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine extends Command
{
    Drive drv; 
    CommandGroup cmdGrp;
    
    public AutoLine()
    {
        cmdGrp.addParallel(new DriveFwd(), 1.5);
    }

    @Override
    public void execute()
    {
         
    }

	@Override
	protected boolean isFinished() 
    {
		return false;
	}
    
}