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
    private RobotMap rm; // CR 9
    private ControlMode cm; // CR 10

    public BallGatherSys()
    {
        this.assemblyLineMotor = new WPI_TalonSRX(rm.ASSEMBLY_LINE_MOTOR);
        this.suctionMotor = new WPI_TalonSRX(rm.SUCTION_MOTOR);
        this.shootMotorRight = new WPI_TalonSRX(rm.SHOOT_MOTOR_RIGHT);
        this.shootMotorLeft = new WPI_TalonSRX(rm.SHOOT_MOTOR_LEFT);
    }

// CR 9
    public void Suck(double suctionMotorVal)
    {
        this.assemblyLineMotor.set(cm.PercentOutput, -suctionMotorVal);
        this.suctionMotor.set(cm.PercentOutput, -suctionMotorVal);
    }
    
	// CR 9
    public void Shoot(double asmblyLineMotorVal, double shootMotorVal)
    {
        this.assemblyLineMotor.set(cm.PercentOutput, -asmblyLineMotorVal);
        this.shootMotorRight.set(cm.PercentOutput, shootMotorVal);
        this.shootMotorLeft.set(cm.PercentOutput, -shootMotorVal);
    }

// CR 9
    public void MoveAssemblyLine(double assemblyLineMotorVal)
    {
        this.assemblyLineMotor.set(cm.PercentOutput, -assemblyLineMotorVal);
    }

    public void emergencyStop()
    {
        this.suctionMotor.set(cm.PercentOutput, 0);
        this.assemblyLineMotor.set(cm.PercentOutput, 0);
        this.shootMotorRight.set(cm.PercentOutput, 0);
        this.shootMotorLeft.set(cm.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {

    }
}