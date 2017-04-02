package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OpenGearHolder extends Command
{

	private String openPositionKey = null;
	
	private double openPosition;
	
	public OpenGearHolder()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.gearHolder);
	}
	
	public OpenGearHolder(String openPositionKey)
	{
		this();
		this.openPositionKey = openPositionKey;
	}
	
	public OpenGearHolder(double openPosition)
	{
		this();
		this.openPosition = openPosition;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		if (openPositionKey != null)
		{
			openPosition = SmartDashboard.getNumber(openPositionKey, 0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		Robot.gearHolder.setPosition(openPosition);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return isCanceled();
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
