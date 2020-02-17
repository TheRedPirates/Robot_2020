package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArcadeDriveSubsystem extends Subsystem {
    //private RobotMap rm;
    //public RobotDrive m_RobotDrive;
    public WPI_TalonSRX T1, T2, T3, T4;
    public DifferentialDrive diffDrive;
    public SpeedControllerGroup d_Right, d_Left;
  public ArcadeDriveSubsystem() {
    this.T1 = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_RIGHT);
    this.T2 = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_RIGHT);
    this.d_Right = new SpeedControllerGroup(this.T1, this.T2);

    this.T3 = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_FRONT_LEFT);
    this.T4 = new WPI_TalonSRX(RobotMap.DRIVE_MOTOR_REAR_LEFT);
    this.d_Left = new SpeedControllerGroup(this.T3, this.T4);
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
