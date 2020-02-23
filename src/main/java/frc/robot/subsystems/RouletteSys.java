package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;

public class RouletteSys extends Subsystem 
{
    private TalonSRX motor;

    public RouletteSys()
    {
        this.motor = new WPI_TalonSRX(RobotMap.ROULETTE_MOTOR);
    }
	
    public void Spin(double motorVal)
    {
        this.motor.setNeutralMode(NeutralMode.Coast);
        this.motor.set(ControlMode.PercentOutput, motorVal);
    }

    public void 
    emergencyStop()
    {
        this.motor.set(ControlMode.PercentOutput, 0);
        this.motor.setNeutralMode(NeutralMode.Brake);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}