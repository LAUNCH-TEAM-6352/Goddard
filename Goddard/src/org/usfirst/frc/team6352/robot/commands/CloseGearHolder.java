package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CloseGearHolder extends Command
{
	private String closedPositionKey = null;
	
	private double closedPosition;
	
	public CloseGearHolder()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.gearHolder);
	}
	
	public CloseGearHolder(String closedPositionKey)
	{
		this();
		this.closedPositionKey = closedPositionKey;
	}
	
	public CloseGearHolder(double closedPosition)
	{
		this();
		this.closedPosition = closedPosition;
	}
	
	// Called just before this Command runs the first time
	protected void initialize()
	{
		if (closedPositionKey != null)
		{
			closedPosition = SmartDashboard.getNumber(closedPositionKey, .8);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.gearHolder.setPosition(closedPosition);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
