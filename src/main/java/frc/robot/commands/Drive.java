package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class Drive extends Command {
  
  public Drive() {
    requires(Robot.m_tankDriveSys);
  }
  @Override
  protected void execute() {
    Robot.m_tankDriveSys.Drive(Robot.m_oi.joystick1);
    Robot.m_tankDriveSys.diffDrive.feedWatchdog();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}
