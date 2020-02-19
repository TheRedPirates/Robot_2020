package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveFwd extends Command 
{  
  public DriveFwd() 
  {
  	  requires(Robot.m_arcadeDriveSys);
  }

  @Override
  protected void execute() 
  {
  	  Robot.m_arcadeDriveSys.DriveFwd();
  	  Robot.m_arcadeDriveSys.diffDrive.feedWatchdog();
  }
  
  @Override
  protected boolean isFinished() 
  {
  	  return false;
  }
}
