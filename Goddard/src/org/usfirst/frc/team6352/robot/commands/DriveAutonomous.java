package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that drives the robot in the autonomous period.
 */
public class DriveAutonomous extends Command
{

	public DriveAutonomous()
	{
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println("Hello from DriveAutonomous.initialize()!");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.driveTrain.stop();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isTimedOut() || isCanceled();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveTrain.stop();
		System.out.println("Goodbye from DriveAutonomous.end()!");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
