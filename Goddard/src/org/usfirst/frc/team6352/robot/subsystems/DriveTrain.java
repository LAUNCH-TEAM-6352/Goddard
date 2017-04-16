package org.usfirst.frc.team6352.robot.subsystems;

import org.usfirst.frc.team6352.robot.RobotMap;
import org.usfirst.frc.team6352.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team6352.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem that moves the robot.
 */
public class DriveTrain extends Subsystem
{
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	RobotDrive drive;
	
	public DriveTrain()
	{
		drive = RobotMap.isCompetitionRobot
				? new RobotDrive(new Spark(RobotMap.leftDriveChannel), new Spark(RobotMap.rightDriveChannel))
				: new RobotDrive(new Victor(RobotMap.leftDriveChannel), new Victor(RobotMap.rightDriveChannel));
		 
		drive.setInvertedMotor(MotorType.kRearLeft, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}

	public void stop()
	{
		drive.stopMotor();
	}
	
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoysticks());
	}
	
	/**
	 * Arcade style drive using input from a single joystick.
	 * @param stick
	 */
	public void driveArcade(Joystick stick)
	{
		drive.arcadeDrive(stick);
	}
	
	/**
	 * Tank style drive using input from two joysticks, left and right.
	 * @param leftStick
	 * @param rightStick
	 */
	public void driveTank(Joystick leftStick, Joystick rightStick)
	{
		drive.tankDrive(leftStick, rightStick);
	}
	
	/**
	 * Team Caution style drive using input from two joysticks, left and right.
	 * @param leftStick
	 * @param rightStick
	 */
	public void driveCaution(Joystick leftStick, Joystick rightStick)
	{
		 setLeftRightMotorOutputs(leftStick.getY() - rightStick.getX(), leftStick.getY() + rightStick.getX());
	}
	
	public void setLeftRightMotorOutputs(double left, double right)
	{
		drive.setLeftRightMotorOutputs(left, right);
	}
	
	/**
	 * Drives with a specified speed and curve.
	 * @param speed Between -1.0 and 1.0: >0 is forward while <0 is reverse.
	 * @param curve Between -1.0 and 1.0: >0 is turn right while <0 is turn left.
	 */
	public void drive(double speed, double curve)
	{
		drive.drive(speed,  curve);
	}
	
}
