/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI 
{
    public Joystick systemsJoystick;
    public Joystick driverJoystick;
    public JoystickButton[] systemsJoystickButtons;
    public JoystickButton[] driverJoystickButtons;

    public OI() 
    {
        this.systemsJoystick = new Joystick(RobotMap.SYSTEMS_JOYSTICK);
        this.driverJoystick = new Joystick(RobotMap.DRIVER_JOYSTICK_LEFT);

        this.systemsJoystickButtons = new JoystickButton[12];
        this.driverJoystickButtons = new JoystickButton[12];
      
        for (int buttonNumber = 0; buttonNumber < RobotMap.NUM_OF_JOYSTICK_BUTTONS; buttonNumber++) 
        {
            this.systemsJoystickButtons[buttonNumber] = new JoystickButton(this.systemsJoystick, buttonNumber); 
            this.driverJoystickButtons[buttonNumber] = new JoystickButton(this.driverJoystick, buttonNumber);
        }
       
        this.systemsJoystickButtons[1].whileHeld(new ShootBalls());
        this.systemsJoystickButtons[3].whenPressed(new SpinRoulette(0.9)); 
        this.systemsJoystickButtons[4].whileHeld(new ClimbDown());
        this.systemsJoystickButtons[6].whileHeld(new ClimbUp());
    }

	public Joystick getDriverJoystick() 
	{
		return this.driverJoystick;
    }

	public Joystick getSystemsJoystick() 
	{
		return this.systemsJoystick;
    }
    
    public JoystickButton getGatherButton()
    {
        return this.systemsJoystickButtons[2];
    }
}