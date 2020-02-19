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



public class OI {
  public Joystick driverLeftJoystick;
  public Joystick driverRightJoystick;
  public JoystickButton [] driverLeftJoystickButtons;
  public JoystickButton [] driverRightJoystickButtons;
  // CR 0
  
  RobotMap robotMap;
  
  public OI()
 {
   try 
   {
    System.out.println("[System]<- Joysick Definition");
    this.driverLeftJoystick = new Joystick(this.robotMap.DRIVER_LEFT_JOYSTICK);
	// CR 1
    //this.joystick2 = new Joystick(this.robotMap.JOYSTICK_2);
    //this.JbuttonLeft = new JoystickButton[11];
    this.driverLeftJoystickButtons = new JoystickButton[12];
    /*for(int i = 0; i<JbuttonLeft.length; i++){
      this.JbuttonLeft[i] = new JoystickButton(this.joystick2,i);
    }*/
      for(int i = 0; i < driverLeftJoystickButtons.length; i++){
        this.driverLeftJoystickButtons[i] = new JoystickButton(this.driverLeftJoystick,i);
		// CR 2
      }
    }
    catch (Exception error) {
      System.out.println(error.toString());
    }
    //this.JbuttonRight[6].whileHeld(new moveClimb(0));
    //this.JbuttonLeft[4].whileHeld(new moveClimb(1));
   this.driverLeftJoystickButtons[1].whileHeld(new ShootBalls());
    this.driverLeftJoystickButtons[3].whileHeld(new GatherBalls());
    this.driverLeftJoystickButtons[2].whileHeld(new MoveBalls());
  this.driverLeftJoystickButtons[4].whileHeld(new SpinRoulette(0.9));
 } 
   

 public Joystick getRightJoystick()
 {
    return this.driverRightJoystick;
 }

 public Joystick getLeftJoystick()
 {
  return this.driverLeftJoystick;
 }

}
