package org.usfirst.frc.team6352.robot;

import org.usfirst.frc.team6352.robot.commands.Climb;
import org.usfirst.frc.team6352.robot.commands.MoveGearLiftDown;
import org.usfirst.frc.team6352.robot.commands.MoveGearLiftUp;
import org.usfirst.frc.team6352.robot.commands.OpenGearHolder;
import org.usfirst.frc.team6352.robot.commands.UnwindClimbingWinch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// The joysticks used for driving:
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(2);

	// The Xbox controller used to activate various subsystems:
	public XboxController gameController = new XboxController(1);

	// Buttons:

	// Give meaningful names to the game controller buttons:
	public final static int gameControllerButtonA = 1;
	public final static int gameControllerButtonB = 2;
	public final static int gameControllerButtonX = 3;
	public final static int gameControllerButtonY = 4;
	public final static int gameControllerButtonBumperLeft = 5;
	public final static int gameControllerButtonBumperRight = 6;
	public final static int gameControllerButtonBack = 7;
	public final static int gameControllerButtonStart = 8;
	public final static int gameControllerButtonStickLeft = 9;
	public final static int gameControllerButtonStickRight = 10;

	Button gearLiftUpButton = new JoystickButton(gameController, gameControllerButtonY);
	Button gearLiftDownButton = new JoystickButton(gameController, gameControllerButtonA);
	
	Button gearHolderOpenButton = new JoystickButton(gameController, gameControllerButtonX);
	
	Button climbingWinchButton = new JoystickButton(gameController, gameControllerButtonB);

	// SmartDashboard keys:
	public final static String dashboardGearLiftSpeedUp = "Gear Lift Speed Up";
	public final static String dashboardGearLiftSpeedDown = "Gear Lift Speed Down";
	public final static String dashboardGearLiftTimeout = "Gear Lift Timeout (secs)";
	public final static String dashboardGearHolderOpen = "Gear Holder Open";
	public final static String dashboardGearHolderClosed = "Gear Holder Closed";
	public final static String dashboardClimbingWinchSpeed = "Climbing Speed";
	public final static String dashboardUnwindClimbingWinchSpeed = "Unwind Speed";

	// Constructor:
	public OI()
	{
		// Bind buttons to commands:
		gearLiftUpButton.whenPressed(new MoveGearLiftUp());
		gearLiftDownButton.whenPressed(new MoveGearLiftDown());
		
		climbingWinchButton.whileHeld(new Climb(dashboardClimbingWinchSpeed));
		gearHolderOpenButton.whileHeld(new OpenGearHolder(dashboardGearHolderOpen));

		// Put default values on SmartDashboard:
		SmartDashboard.putNumber(dashboardGearLiftSpeedUp, 0.5);
		SmartDashboard.putNumber(dashboardGearLiftSpeedDown, -0.4);
		SmartDashboard.putNumber(dashboardGearLiftTimeout, 5.0);
		SmartDashboard.putNumber(dashboardGearHolderOpen, 0);
		SmartDashboard.putNumber(dashboardGearHolderClosed, .8);
		SmartDashboard.putNumber(dashboardClimbingWinchSpeed, -0.75);
		SmartDashboard.putNumber(dashboardUnwindClimbingWinchSpeed, +0.75);
		
		// THis adds a button to the SmartDashboard to unwind the climbing winch
		SmartDashboard.putData("Unwind Climber", new UnwindClimbingWinch(dashboardUnwindClimbingWinchSpeed));
	}
}
