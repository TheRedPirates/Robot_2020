package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine extends Command
{
    Drive drv; 
    CommandGroup cmdGrp;
    
    public AutoLine()
    {
        //init code
    }

    @Override
    public void execute()
    {
        cmdGrp.addParallel(new DriveFwd(), 1.5);
    }

	@Override
	protected boolean isFinished() 
    {
		return false;
	}
    
}