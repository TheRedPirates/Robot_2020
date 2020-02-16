package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class BallGatherSys extends Subsystem{
    private TalonSRX assemblyLineMotor;
    private TalonSRX suctionMotor;
    private TalonSRX shootMotor;
    private RobotMap rm;
    private ControlMode cm;
    public BallGatherSys(){
        this.assemblyLineMotor = new WPI_TalonSRX(rm.assmlyLineMotor);
        this.suctionMotor = new WPI_TalonSRX(rm.suctionMotor);
        this.shootMotor = new WPI_TalonSRX(rm.shootMotor);
    }
    public void Suck(double suctionMotorVal, double asmblyLineMotorVal){
        this.assemblyLineMotor.set(cm.PercentOutput, asmblyLineMotorVal);
        this.suctionMotor.set(cm.PercentOutput, suctionMotorVal);
    }
    public void Shoot(double asmblyLineMotorVal, double shootMotorVal){
        this.assemblyLineMotor.set(cm.PercentOutput, asmblyLineMotorVal);
        this.shootMotor.set(cm.PercentOutput, shootMotorVal);
    }
    public void emergencyStop(){
        this.suctionMotor.set(cm.PercentOutput, 0);
        this.assemblyLineMotor.set(cm.PercentOutput, 0);
        this.shootMotor.set(cm.PercentOutput, 0);
    }
    @Override
    protected void initDefaultCommand() {

    }

}