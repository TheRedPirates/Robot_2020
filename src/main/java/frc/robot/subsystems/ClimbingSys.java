package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DigitalInput;
public class ClimbingSys extends Subsystem 
{
    private TalonSRX openRackMotor;
    private TalonSRX closeRackMotor;
    private DigitalInput stopper;

    public ClimbingSys()
    {
        this.openRackMotor = new WPI_TalonSRX(RobotMap.OPEN_RACK_MOTOR);
        this.closeRackMotor = new WPI_TalonSRX(RobotMap.CLOSE_RACK_MOTOR);
        this.stopper = new DigitalInput(RobotMap.OPEN_RACK_MICROSWITCH_PORT);
    }
	
    public void openRacK(double motorVal)
    {
        this.openRackMotor.set(ControlMode.PercentOutput, motorVal);
    }

    public boolean getMicroSwitch()
    {
        return !stopper.get();
    }

    public void closeRack(double motorVal)
    {
        this.openRackMotor.set(ControlMode.PercentOutput,-motorVal);
        System.out.println("Closed!");
    }

    public void emergencyStop()
    {
        this.openRackMotor.set(ControlMode.PercentOutput, 0);
        this.closeRackMotor.set(ControlMode.PercentOutput, 0);
        this.openRackMotor.setNeutralMode(NeutralMode.Brake);
        this.closeRackMotor.setNeutralMode(NeutralMode.Brake);

    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}