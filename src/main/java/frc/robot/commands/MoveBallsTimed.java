package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.m_BallGatherSys;
public class MoveBallsTimed extends Command {
    public MoveBallsTimed() {
        requires(m_BallGatherSys);
    }
}