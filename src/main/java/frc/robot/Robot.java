/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.commands.*;
import frc.robot.triggers.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.util.Color;

//import frc.robot.subsystems.TankDriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Camera m_cameraA;
  public static Camera m_cameraB;
  public static OI m_oi;
  public static AutoLine aLine;
  public static BallGatherSys m_BallGatherSys;
  public static AssemblyLineSys m_AssemblyLineSys;
  public static BallShootSys m_BallShootSys;
  public static ArcadeDriveSubsystem m_arcadeDriveSys;
  public static RouletteSys m_RouletteSys;
  public static StackLoaderTrigger stackTrigger;
  I2C.Port port = I2C.Port.kOnboard;
  ColorSensorV3 ColorSensor = new ColorSensorV3(port);

  public static Drive m_drive;
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(100, 100, 100);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  @Override
  public void robotInit() {
    m_cameraA = new Camera();
    m_cameraB = new Camera();
    System.out.println("started");
    m_BallGatherSys = new BallGatherSys();
    m_RouletteSys = new RouletteSys();
    m_BallShootSys = new BallShootSys();
    m_AssemblyLineSys = new AssemblyLineSys();
    stackTrigger = new StackLoaderTrigger();
    m_oi = new OI();
    m_arcadeDriveSys = new ArcadeDriveSubsystem(m_oi.getDriverLeftJoystick(), m_oi.getDriverRightJoystick());
    m_arcadeDriveSys.diffDrive.feed();
    m_arcadeDriveSys.diffDrive.feedWatchdog();
    
	
    


   

   // BGS = new BallGatherSys();
    
   // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
	  
    m_arcadeDriveSys.diffDrive.feed();
    m_arcadeDriveSys.diffDrive.feedWatchdog();
    //System.out.println(stackTrigger.get());
    //System.out.println(sMS.get());
    stackTrigger.whileActive(new MoveBallsTimed());

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget); 
    Color detectedColor = ColorSensor.getColor();

    /**
     * Run the color match algorithm on our detected color
     */
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    
    if (match.color == kBlueTarget) {
      RobotMap.colorSensorString = "B";
    } else if (match.color == kRedTarget) {
      RobotMap.colorSensorString = "R";
    } else if (match.color == kGreenTarget) {
      RobotMap.colorSensorString = "G";
    } else if (match.color == kYellowTarget) {
      RobotMap.colorSensorString = "Y";
    } else {
      RobotMap.colorSensorString = "Unknown";
    }
    if (RobotMap.colorSensorString == "R")
    {  
      System.out.println("Red!");
    }   
    SmartDashboard.putString("color", RobotMap.colorSensorString);
   
  }
  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    System.out.println("[AutoLine]-> start!");
    aLine = new AutoLine();
    System.out.println("[AutoLine]-> end!");
    
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() 
  {
    m_arcadeDriveSys.diffDrive.feed();
    m_arcadeDriveSys.diffDrive.feedWatchdog();
  
    if (m_autonomousCommand != null) 
    {
        m_autonomousCommand.cancel();
    }  
  }

    @Override
    public void teleopPeriodic() 
    {
      m_arcadeDriveSys.diffDrive.feed();
      m_arcadeDriveSys.diffDrive.feedWatchdog();
      m_arcadeDriveSys.Drive();
    
      Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() 
    {

    }
}
