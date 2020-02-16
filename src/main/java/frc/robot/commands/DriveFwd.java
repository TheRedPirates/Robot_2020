
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class DriveFwd extends Command {
  
  public DriveFwd() {
    requires(Robot.m_tankDriveSys);
  }
  @Override
  protected void execute() {
    Robot.m_tankDriveSys.DriveFwd();
    Robot.m_tankDriveSys.diffDrive.feedWatchdog();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}
