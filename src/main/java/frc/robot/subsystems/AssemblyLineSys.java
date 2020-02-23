package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;

public class AssemblyLineSys extends Subsystem 
{
    private TalonSRX assemblyLineMotor;
    private DigitalInput stackLoader;
    private boolean isBusy;

    public AssemblyLineSys()
    {
        this.assemblyLineMotor = new WPI_TalonSRX(RobotMap.ASSEMBLY_LINE_MOTOR);
        this.stackLoader = new DigitalInput(RobotMap.BALL_STACK_MICROSWITCH);
        this.isBusy = false;
    }

    public void MoveAssemblyLine(double assemblyLineMotorVal)
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, -assemblyLineMotorVal);
    }

    public boolean isStackLoaderActive()
    {
        return !this.stackLoader.get();
    }

    public boolean getIsBusy()
    {
        return this.isBusy;
    }

    public void lock()
    {
        this.isBusy = true;
    }

    public void unlock()
    {
        this.isBusy = false;
    }

    public void emergencyStop()
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, 0);
    }
    
    @Override
    protected void initDefaultCommand() 
    {
    }
}