package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UnwindClimbingWinch extends Command
{

	private String speedKey = null;
	
	private double speed;
	
	private UnwindClimbingWinch()
	{
		requires(Robot.climbingWinch);
	}
	
	public UnwindClimbingWinch(String speedKey)
	{
		this();
		this.speedKey = speedKey;
	}
	
	public UnwindClimbingWinch(double speed)
	{
		this();
		this.speed = speed;
	}
	
	// Called just before this Command runs the first time
	protected void initialize()
	{
		if (speedKey != null)
		{
			speed = SmartDashboard.getNumber(speedKey, 0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.climbingWinch.setSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isCanceled();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.climbingWinch.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
