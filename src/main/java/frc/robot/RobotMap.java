package frc.robot;

import com.revrobotics.*;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;

public class RobotMap 
{
    // Joysicks
    public static final int DRIVER_JOYSTICK_LEFT = 1;
    public static final int DRIVER_JOYSTICK_RIGHT = 3;
    public static final int SYSTEMS_JOYSTICK = 0;
    
    // Buttons
    public static final int NUM_OF_JOYSTICK_BUTTONS = 12;
    public static final int SHOOT_BALLS_BUTTON = 1;
    public static final int GATHER_BALLS_BUTTON = 2;
    public static final int ROULETTE_BUTTON = 3;
    public static final int CLIMB_DOWN_BUTTON = 4;
    public static final int CLIMB_UP_BUTTON = 6;

	// Drive
    public static final int DRIVE_MOTOR_FRONT_RIGHT = 4;
    public static final int DRIVE_MOTOR_FRONT_LEFT = 2;
    public static final int DRIVE_MOTOR_REAR_RIGHT = 3;
    public static final int DRIVE_MOTOR_REAR_LEFT = 1;
	
	// Balls
	public static final int SHOOT_MOTOR_RIGHT = 8;
    public static final int SHOOT_MOTOR_LEFT = 7;
    public static final int ASSEMBLY_LINE_MOTOR = 6;
    public static final int SUCTION_MOTOR = 5;
	public static final int BALL_STACK_MICROSWITCH = 1;
	public static int ballCount = 0;

	// Roulette
	public static final int ROULETTE_MOTOR = 9;
    public static String colorSensorString = "color";
    public static final I2C.Port COLOR_SENSOR_PORT = I2C.Port.kOnboard;  
    public static final Color BLUE = ColorMatch.makeColor(0, 1, 1);
    public static final Color GREEN = ColorMatch.makeColor(0, 1, 0);
    public static final Color RED = ColorMatch.makeColor(1., 0, 0);
    public static final Color YELLOW = ColorMatch.makeColor(1, 1, 0);

    // Climbing
    public static final int OPEN_RACK_MOTOR = 10;
    public static final int CLOSE_RACK_MOTOR = 11;

	// Cameras
	public static final int SUCK_CAMERA_PORT = 0;
    public static final int FIELD_CAMERA_PORT = 1;
}
