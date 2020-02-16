package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutoLine extends Command{
    Drive drv; //naming for convenience 
    CommandGroup cmdGrp;
    public AutoLine(){
        //init code
    }

    public void execute(){
        cmdGrp.addParallel(new DriveFwd(), 1.5);
    }


	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
    
}