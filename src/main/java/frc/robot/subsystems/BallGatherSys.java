package frc.robot.subsystems;

import edu.wpi.first.hal.sim.DigitalPWMSim;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;

// CR 7
public class BallGatherSys extends Subsystem 
{
    private TalonSRX suctionMotor;

    public BallGatherSys()
    {
        this.suctionMotor = new WPI_TalonSRX(RobotMap.SUCTION_MOTOR);
    }

    public void Suck(double suctionMotorVal)
    {
        this.suctionMotor.set(ControlMode.PercentOutput, -suctionMotorVal);
    }

    public void emergencyStop()
    {
        this.suctionMotor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {

    }
}