/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //public static final int pushRodMotor = 99; // Needs changing
  public static final int DRIVE_MOTOR_FRONT_RIGHT = 4;
  public static final int DRIVE_MOTOR_FRONT_LEFT = 2;
  public static final int DRIVE_MOTOR_REAR_RIGHT = 3;
  public static final int DRIVE_MOTOR_REAR_LEFT = 1;
  public static final int DRIVER_LEFT_JOYSTICK = 1; // Needs changing
  public static final int DRIVER_RIGHT_JOYSTICK = 0; // Needs changing
  public static final int SYSTEMS_JOYSTICK = 2; // Needs changing
  public static final int DIO_A = 0;
  public static final int SHOOT_MOTOR_RIGHT = 8;
  public static final int SHOOT_MOTOR_LEFT = 7;
  public static final int ASSEMBLY_LINE_MOTOR = 6;
  public static final int SUCTION_MOTOR = 5;
  public static final int ROULETTE_MOTOR = 9;
  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
