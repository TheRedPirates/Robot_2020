package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ClimbingSys extends Subsystem{
    private TalonSRX pushRodMotor;
    private RobotMap rm;
    private ControlMode cm;
    public ClimbingSys(){
        this.pushRodMotor = new WPI_TalonSRX(this.rm.pushRodMotor);
    }
    public void Climb(double pushRodMotorVal){
        this.pushRodMotor.set(cm.PercentOutput, pushRodMotorVal);
    }
    /*public void highClimb(double pushRodMotorVal){
        this.pushRodMotor.set(cm.PercentOutput, pushRodMotorVal);
    }*/
    public void emergencyStop(){
        this.pushRodMotor.set(cm.PercentOutput, 0.0);
    }
    @Override
    protected void initDefaultCommand() {

    }

}