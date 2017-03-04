package org.usfirst.frc.team6352.robot.subsystems;

import org.usfirst.frc.team6352.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
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
		// setDefaultCommand(new MySpecialCommand());

	}
	
	public void driveArcade(Joystick stick)
	{
		drive.arcadeDrive(stick);
		
	}
	
}
