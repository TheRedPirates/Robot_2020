package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

// CR 6
public class ArcadeDriveSubsystem extends Subsystem {
    public WPI_TalonSRX FRONT_RIGHT_TALON, REAR_RIGHT_TALON, FRONT_LEFT_TALON, REAR_LEFT_TALON; // CR 5
    public DifferentialDrive diffDrive;
    public SpeedControllerGroup d_Right, d_Left;
    private Joystick leftStick;
    private Joystick rightStick;

  public ArcadeDriveSubsystem(Joystick leftStick, Joystick rightStick) {
    this.FRONT_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_RIGHT);
    this.REAR_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_RIGHT);
    this.d_Right = new SpeedControllerGroup(this.FRONT_RIGHT_TALON, this.REAR_RIGHT_TALON);

    this.FRONT_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_LEFT);
    this.REAR_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_LEFT);
    this.d_Left = new SpeedControllerGroup(this.FRONT_LEFT_TALON, this.REAR_LEFT_TALON);
    this.diffDrive = new DifferentialDrive(d_Left, d_Right);
    this.diffDrive.setSafetyEnabled(false);
    this.leftStick = leftStick;
    this.rightStick = rightStick;
  }

  public void Drive() {
    this.diffDrive.feedWatchdog();
    this.diffDrive.feed();
    this.diffDrive.tankDrive(-this.leftStick.getY() * 0.8, -this.rightStick.getY() * 0.8);
    this.diffDrive.feedWatchdog();
    this.diffDrive.feed();
  }
  public void DriveFwd(){
    this.diffDrive.arcadeDrive(0.5, 0);
  }
  @Override
  public void initDefaultCommand() {

  }
}
