package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

// CR 6
public class ArcadeDriveSubsystem extends Subsystem {
    public WPI_TalonSRX FRONT_RIGHT_TALON, REAR_RIGHT_TALON, FRONT_LEFT_TALON, REAR_LEFT_TALON; // CR 5
    public DifferentialDrive diffDrive;
    public SpeedControllerGroup d_Right, d_Left;
  public ArcadeDriveSubsystem() {
    this.FRONT_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_RIGHT);
    this.REAR_RIGHT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_RIGHT);
    this.d_Right = new SpeedControllerGroup(this.FRONT_RIGHT_TALON, this.REAR_RIGHT_TALON);

    this.FRONT_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_LEFT);
    this.REAR_LEFT_TALON = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_LEFT);
    this.d_Left = new SpeedControllerGroup(this.FRONT_LEFT_TALON, this.REAR_LEFT_TALON);
    this.diffDrive = new DifferentialDrive(d_Left, d_Right);
    //this.m_RobotDrive.setSafetyEnabled(false);
  }

  public void Drive(Joystick stick) {
    double diffX, diffY;
    diffX = stick.getX();
    diffY = -stick.getY();
    System.out.println(diffX+","+diffY);
    this.diffDrive.arcadeDrive(diffY, diffX);
    this.diffDrive.feedWatchdog();
  }
  public void DriveFwd(){
    this.diffDrive.arcadeDrive(0.5, 0);
  }
  @Override
  public void initDefaultCommand() {

  }
}
