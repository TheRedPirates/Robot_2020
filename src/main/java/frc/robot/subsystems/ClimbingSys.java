package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;

public class ClimbingSys extends Subsystem 
{
    private TalonSRX openRackMotor;
    private TalonSRX closeRackMotor;

    public ClimbingSys()
    {
        this.openRackMotor = new WPI_TalonSRX(RobotMap.OPEN_RACK_MOTOR);
        this.closeRackMotor = new WPI_TalonSRX(RobotMap.CLOSE_RACK_MOTOR);
    }
	
    public void openRacK(double motorVal)
    {
        this.openRackMotor.set(ControlMode.PercentOutput, motorVal);
    }

    public void closeRack(double motorVal)
    {
        this.closeRackMotor.set(ControlMode.PercentOutput, motorVal);
    }

    public void emergencyStop()
    {
        this.openRackMotor.set(ControlMode.PercentOutput, 0);
        this.closeRackMotor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}