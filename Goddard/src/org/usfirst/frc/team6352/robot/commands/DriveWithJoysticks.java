package org.usfirst.frc.team6352.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6352.robot.Robot;

/**
 * Drives the robot tank style using input from two joysticvks.
 */
public class DriveWithJoysticks extends Command
{
	public DriveWithJoysticks()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		//Robot.driveTrain.driveTank(Robot.oi.leftStick, Robot.oi.rightStick);
		Robot.driveTrain.driveCaution(Robot.oi.leftStick, Robot.oi.rightStick);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
