/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.triggers.StackLoaderTrigger;

public class OI 
{
    //public Joystick systemsJoystick;
    public Joystick driverJoystickLeft;
    public Joystick driverJoystickRight;
    //public JoystickButton[] systemJoystickButtons;
    public JoystickButton[] driverJoystickLeftButtons;
    public JoystickButton[] driverJoystickRightButtons;

    public OI() 
    {
        //this.systemsJoystick = new Joystick(RobotMap.SYSTEMS_JOYSTICK);
        this.driverJoystickLeft = new Joystick(RobotMap.DRIVER_JOYSTICK_LEFT);
        this.driverJoystickRight = new Joystick(RobotMap.DRIVER_JOYSTICK_RIGHT);
      
        for (int buttonNumber = 0; buttonNumber < RobotMap.NUM_OF_JOYSTICK_BUTTONS; buttonNumber++) 
        { 
            //this.systemJoystickButtons[buttonNumber] = new JoystickButton(this.systemsJoystick, buttonNumber);
            //this.driverJoystickLeftButtons[buttonNumber] = new JoystickButton(this.driverJoystickLeft, buttonNumber);
            //this.driverJoystickRightButtons[buttonNumber] = new JoystickButton(this.driverJoystickRight, buttonNumber);
        }
      
        //this.systemJoystickButtons[1].whileHeld(new ShootBalls());
        //this.systemJoystickButtons[2].whileHeld(new GatherBall());
        //this.systemJoystickButtons[3].whenPressed(new SpinRoulette(0.9));    
    }

	public Joystick getDriverLeftJoystick() 
	{
		return this.driverJoystickLeft;
    }

	public Joystick getDriverRightJoystick() 
	{
		return this.driverJoystickRight;
	}
}
