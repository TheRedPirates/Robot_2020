package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

public class ClimbingSys extends Subsystem 
{
    private TalonSRX rackMotor;
    private TalonSRX climbMotor;
    private DigitalInput stopper;

    public ClimbingSys()
    {
        this.rackMotor = new WPI_TalonSRX(RobotMap.RACK_MOTOR);
        this.climbMotor = new WPI_TalonSRX(RobotMap.CLIMB_MOTOR);
        this.stopper = new DigitalInput(RobotMap.RACK_MICROSWITCH_PORT);
    }
	
    public void openRacK(double motorVal)
    {
        this.rackMotor.set(ControlMode.PercentOutput, -motorVal);
    }

    public void closeRack(double motorVal)
    {
        this.rackMotor.set(ControlMode.PercentOutput, motorVal);
    }

    public void climb(double motorVal)
    {
        this.climbMotor.set(ControlMode.PercentOutput, motorVal);
    }

    public boolean getStopper()
    {
        return !stopper.get();
    }

    public void emergencyStop()
    {
        this.climbMotor.set(ControlMode.PercentOutput, 0);
        this.rackMotor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}