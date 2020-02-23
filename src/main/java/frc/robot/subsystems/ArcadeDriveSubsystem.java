package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArcadeDriveSubsystem extends Subsystem 
{
	private WPI_TalonSRX FRONT_RIGHT_TALON; 
	private WPI_TalonSRX REAR_RIGHT_TALON;
	private WPI_TalonSRX FRONT_LEFT_TALON; 
	private WPI_TalonSRX REAR_LEFT_TALON;
    private DifferentialDrive diffDrive;
    private SpeedControllerGroup rightMotors;
    private SpeedControllerGroup leftMotors;
    private Joystick driveStick;

    public ArcadeDriveSubsystem(Joystick driveStick) 
    {
        this.FRONT_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_RIGHT);
        this.REAR_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_RIGHT);
        this.rightMotors = new SpeedControllerGroup(this.FRONT_RIGHT_TALON, this.REAR_RIGHT_TALON);

        this.FRONT_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_LEFT);
        this.REAR_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_LEFT);
        this.leftMotors = new SpeedControllerGroup(this.FRONT_LEFT_TALON, this.REAR_LEFT_TALON);
    
        this.diffDrive = new DifferentialDrive(this.leftMotors, this.rightMotors);
        this.diffDrive.setSafetyEnabled(false);
        this.driveStick = driveStick;
    }

    public void Drive() 
    {
        this.diffDrive.feedWatchdog();
        this.diffDrive.feed();
        this.diffDrive.arcadeDrive(-this.driveStick.getY() * 0.75, this.driveStick.getX() * 0.8, true);
        this.diffDrive.feedWatchdog();
        this.diffDrive.feed();
    }

    public void DriveFwd()
    {

        this.diffDrive.arcadeDrive(0.5, 0);
        this.diffDrive.feedWatchdog();
        this.diffDrive.feed();
    }

    @Override
    public void initDefaultCommand() 
    {
    }
}
