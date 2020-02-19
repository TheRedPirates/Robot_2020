package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

// CR 7
public class BallGatherSys extends Subsystem 
{
    private TalonSRX assemblyLineMotor;
    private TalonSRX suctionMotor;
    private TalonSRX shootMotorRight;
    private TalonSRX shootMotorLeft;

    public BallGatherSys()
    {
        this.assemblyLineMotor = new WPI_TalonSRX(RobotMap.ASSEMBLY_LINE_MOTOR);
        this.suctionMotor = new WPI_TalonSRX(RobotMap.SUCTION_MOTOR);
        this.shootMotorRight = new WPI_TalonSRX(RobotMap.SHOOT_MOTOR_RIGHT);
        this.shootMotorLeft = new WPI_TalonSRX(RobotMap.SHOOT_MOTOR_LEFT);
    }

// CR 9
    public void Suck(double suctionMotorVal)
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, -suctionMotorVal);
        this.suctionMotor.set(ControlMode.PercentOutput, -suctionMotorVal);
    }
    
	// CR 9
    public void Shoot(double asmblyLineMotorVal, double shootMotorVal)
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, -asmblyLineMotorVal);
        this.shootMotorRight.set(ControlMode.PercentOutput, shootMotorVal);
        this.shootMotorLeft.set(ControlMode.PercentOutput, -shootMotorVal);
    }

// CR 9
    public void MoveAssemblyLine(double assemblyLineMotorVal)
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, -assemblyLineMotorVal);
    }

    public void emergencyStop()
    {
        this.suctionMotor.set(ControlMode.PercentOutput, 0);
        this.assemblyLineMotor.set(ControlMode.PercentOutput, 0);
        this.shootMotorRight.set(ControlMode.PercentOutput, 0);
        this.shootMotorLeft.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {

    }
}