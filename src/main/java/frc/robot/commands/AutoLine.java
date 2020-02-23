package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine extends CommandGroup
{
    Drive drv; 
    //CommandGroup cmdGrp;
    private boolean isFin = false;
    public AutoLine()
    {
        addParallel(new DriveFwd(), 1);
        isFin = true;
    }

    // @Override
    // public void execute()
    // {
    // }

	@Override
	protected boolean isFinished() 
    {
		return isFin;
	}
    
}