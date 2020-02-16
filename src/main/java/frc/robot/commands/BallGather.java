package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;


public class BallGather extends Command{
    private DigitalInput DI;
    private RobotMap rm;
    private int SSH; // suck or shoot
    public BallGather(int SuckOrShoot){
        requires(Robot.BGS);
        this.DI = new DigitalInput(rm.DIO_A);
        this.SSH = SuckOrShoot;
    }
    @Override
    public void execute(){
        if(this.SSH == 0){// 0 is the indicator for "Suck" mode
            Robot.BGS.Suck(0.5, 0);
            if(DI.get()){
                Robot.BGS.Suck(0.5, 0.8);
            }else if(!DI.get()){
                Robot.BGS.emergencyStop();
            }
            
        }else if (this.SSH == 1){
            Robot.BGS.Shoot(0.8, 0.5);
        }
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

}