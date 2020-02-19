package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class RouletteSys extends Subsystem 
{
    private TalonSRX motor;

    public RouletteSys()
    {
        this.motor = new WPI_TalonSRX(RobotMap.ROULETTE_MOTOR);
    }

	// CR 8
    public void Spin(double motorVal)
    {
        this.motor.set(ControlMode.PercentOutput, motorVal);
    }

    public void emergencyStop()
    {
        this.motor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {

    }
}