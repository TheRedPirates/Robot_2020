package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.triggers.*;
import frc.robot.subsystems.*;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.util.Color;

public class Robot extends TimedRobot 
{
    public static CameraSys m_CameraSys;
    public static OI m_oi;
    public static BallGatherSys m_BallGatherSys;
    public static ClimbingSys m_ClimbingSys;
    public static AssemblyLineSys m_AssemblyLineSys;
    public static BallShootSys m_BallShootSys;
    public static ArcadeDriveSubsystem m_arcadeDriveSys;
    public static RouletteSys m_RouletteSys;
    public static StackLoaderTrigger stackTrigger;
    public static JoystickGatherTrigger manualGatherTrigger;
    public static Drive m_drive;
    public static ColorSensorV3 m_ColorSensor;
    public static ColorMatch m_ColorMatcher;
    public static Color detectedColor;
    public static ColorMatchResult match;
    public static Command m_autonomousCommand;
    public static SendableChooser<Command> m_chooser;
	public static AutoLine autoLine;

    @Override
    public void robotInit() 
    {
		m_chooser = new SendableChooser<>();
        m_ColorMatcher = new ColorMatch();
        m_ColorSensor = new ColorSensorV3(RobotMap.COLOR_SENSOR_PORT);
        m_CameraSys = new CameraSys();
        m_BallGatherSys = new BallGatherSys();
        m_ClimbingSys = new ClimbingSys();
        m_RouletteSys = new RouletteSys();
        m_BallShootSys = new BallShootSys();
        m_AssemblyLineSys = new AssemblyLineSys();
        stackTrigger = new StackLoaderTrigger();
        m_oi = new OI();
        manualGatherTrigger = new JoystickGatherTrigger(m_oi.getGatherButton());
        stackTrigger.whenActive(new MoveBallsTimed());
        manualGatherTrigger.whileActive(new GatherBall());
        m_arcadeDriveSys = new ArcadeDriveSubsystem(m_oi.getDriverJoystick());

        SmartDashboard.putData("Auto mode", m_chooser);
    }

    @Override
    public void robotPeriodic() 
    {
        System.out.println(m_ClimbingSys.getMicroSwitch());

        m_ColorMatcher.addColorMatch(RobotMap.BLUE);
        m_ColorMatcher.addColorMatch(RobotMap.GREEN);
        m_ColorMatcher.addColorMatch(RobotMap.RED);
        m_ColorMatcher.addColorMatch(RobotMap.YELLOW);
        detectedColor = m_ColorSensor.getColor();
        match = m_ColorMatcher.matchClosestColor(detectedColor);

        if (match.color == RobotMap.BLUE) 
        {
            RobotMap.colorSensorString = "B";
        } 
        else if (match.color == RobotMap.RED) 
        {
            RobotMap.colorSensorString = "R";
        } 
        else if (match.color == RobotMap.GREEN) 
        {
            RobotMap.colorSensorString = "G";
        } 
        else if (match.color == RobotMap.YELLOW) 
        {
            RobotMap.colorSensorString = "Y";
        } 
        else 
        {
            RobotMap.colorSensorString = "Unknown";
        }

        SmartDashboard.putString("Detected Color", RobotMap.colorSensorString);

        SmartDashboard.putBoolean("busy", Robot.m_AssemblyLineSys.getIsBusy());
        SmartDashboard.putData(m_AssemblyLineSys);
        SmartDashboard.putData(m_BallGatherSys);
        SmartDashboard.putData(m_BallShootSys);
    }

    @Override
    public void disabledInit() 
    {
    }

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() 
    {
        System.out.println("[AutoLine]-> start!");
        autoLine = new AutoLine();
        System.out.println("[AutoLine]-> end!");

        m_autonomousCommand = m_chooser.getSelected();
        
        if (m_autonomousCommand != null) 
        {
            m_autonomousCommand.start();
        }
    }

  
    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() 
    {
        //m_arcadeDriveSys.diffDrive.feed();
        //m_arcadeDriveSys.diffDrive.feedWatchdog();

        if (m_autonomousCommand != null) 
        {
            m_autonomousCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() 
    {
        //m_arcadeDriveSys.diffDrive.feed();
        //m_arcadeDriveSys.diffDrive.feedWatchdog();
        m_arcadeDriveSys.Drive();

        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() 
    {
    }
}
