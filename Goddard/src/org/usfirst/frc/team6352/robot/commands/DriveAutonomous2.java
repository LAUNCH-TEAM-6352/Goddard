package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A command that drives the robot in the autonomous period.
 */
public class DriveAutonomous2 extends Command
{
	private String leftKey = null;
	private String rightKey = null;
	private String timeoutKey = null;
	
	private double left;
	private double right;
	private double timeout;
	
	/**
	 * Default constructor is private to force outside use of other constructors.
	 */
	private DriveAutonomous2()
	{
		requires(Robot.driveTrain);
	}
	
	/**
	 * Constructs an instance that uses values from the SmartDashboard.
	 * @param leftKey
	 * @param rightKey
	 * @param timeoutKey
	 */
	public DriveAutonomous2(String leftKey, String rightKey, String timeoutKey)
	{
		this();
		this.leftKey = leftKey;
		this.rightKey = rightKey;
		this.timeoutKey = timeoutKey;
	}

	/**
	 * Constructs an instance that uses fixed values.
	 * @param left
	 * @param right
	 * @param timeout
	 */
	public DriveAutonomous2(double left, double right, double timeout)
	{
		this();
		this.left = left;
		this.right = right;
		this.timeout = timeout;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		System.out.println("Hello from DriveAutonomous.initialize()!");
		if (leftKey != null)
		{
			// Get values from SmartDashboard:
			left = SmartDashboard.getNumber(leftKey, 0.5);
			right = SmartDashboard.getNumber(rightKey, 0.0);
			timeout = SmartDashboard.getNumber(timeoutKey, 5.0);
		}
		
		setTimeout(timeout);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		Robot.driveTrain.setLeftRightMotorOutputs(left, right);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return isTimedOut() || isCanceled();
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.driveTrain.stop();
		System.out.println("Goodbye from DriveAutonomous.end()!");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
