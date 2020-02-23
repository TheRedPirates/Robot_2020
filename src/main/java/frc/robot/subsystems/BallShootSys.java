package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class BallShootSys extends Subsystem 
{
    private TalonSRX rightMotor;
    private TalonSRX leftMotor;

    public BallShootSys()
    {
        this.rightMotor = new WPI_TalonSRX(RobotMap.SHOOT_MOTOR_RIGHT);
        this.leftMotor = new WPI_TalonSRX(RobotMap.SHOOT_MOTOR_LEFT);
    }

    public void Shoot(double shootMotorVal)
    {
        this.rightMotor.set(ControlMode.PercentOutput, shootMotorVal);
        this.leftMotor.set(ControlMode.PercentOutput, -shootMotorVal);
    }

    public void emergencyStop()
    {
        this.rightMotor.set(ControlMode.PercentOutput, 0);
        this.leftMotor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}