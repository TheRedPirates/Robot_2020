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
  public Joystick joystick1;
  public Joystick joystick2;
  public JoystickButton [] JbuttonRight;
  public JoystickButton [] JbuttonLeft;
  RobotMap robotMap;
  
  public OI()
 {
   try 
   {
    System.out.println("[System]<- Joysick Definition");
    this.joystick1 = new Joystick(this.robotMap.JOYSTICK_1);
    //this.joystick2 = new Joystick(this.robotMap.JOYSTICK_2);
    //this.JbuttonLeft = new JoystickButton[11];
    this.JbuttonRight = new JoystickButton[11];
    /*for(int i = 0; i<JbuttonLeft.length; i++){
      this.JbuttonLeft[i] = new JoystickButton(this.joystick2,i);
    }*/
      for(int i = 0; i<JbuttonRight.length; i++){
        this.JbuttonRight[i] = new JoystickButton(this.joystick1,i);
      }
    }
    catch (Exception error) {
      System.out.println(error.toString());
    }
    //this.JbuttonRight[6].whileHeld(new moveClimb(0));
    //this.JbuttonLeft[4].whileHeld(new moveClimb(1));
 } 
   

 public Joystick getRightJoystick()
 {
  return this.joystick1;
 }

 public Joystick getLeftJoystick()
 {
  return this.joystick2;
 }

}
