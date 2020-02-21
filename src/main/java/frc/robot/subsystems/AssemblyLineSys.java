package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.MoveBallsTimed;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.triggers.*;
// CR 7
public class AssemblyLineSys extends Subsystem 
{
    private TalonSRX assemblyLineMotor;
    private DigitalInput stackLoader;

    public AssemblyLineSys()
    {
        this.assemblyLineMotor = new WPI_TalonSRX(RobotMap.ASSEMBLY_LINE_MOTOR);
        this.stackLoader = new DigitalInput(RobotMap.BALL_STACK_MICROSWITCH);
    }

    public void MoveAssemblyLine(double assemblyLineMotorVal)
    {
        this.assemblyLineMotor.set(ControlMode.PercentOutput, -assemblyLineMotorVal);
    }

    public boolean isStackLoaderActive()
    {
        return !this.stackLoader.get();
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