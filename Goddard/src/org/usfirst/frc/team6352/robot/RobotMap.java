package org.usfirst.frc.team6352.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// The following indicates if we are running the competition robot:
	public static final boolean isCompetitionRobot = false;

	// The PWM channels for the drive system:
	public static final int leftDriveChannel = 0;
	public static final int rightDriveChannel = 1;

	// The PWM channel for the gear lift:
	public final static int gearLiftChannel = 2;
	
	//The PWM channel for the gear holder:
	public final static int gearHolderChannel = 9;
	
	//The PWM channel for the climbing winch:
	public final static int climbingWinchChannel = 3;
		
	// The following are for configuring the USB cameras.
	// Network bandwidth from the robot to the driver station is limited by the FMS.
	// When using multiple USB cameras, the image size and frame rate may
	// need to be adjusted to stay within the allowed bandwidth.
	// Information about bandwidth limitations can be found at
	// http://wpilib.screenstepslive.com/s/4485/m/24193/l/291972-fms-whitepaper.
	public final static int usbCameraImageWidth = 640;
	public final static int usbCameraImageHeight = 480;
	public final static int usbCameraFrameRate = 10;


}
