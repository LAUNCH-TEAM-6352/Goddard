package org.usfirst.frc.team6352.robot.subsystems;

import org.usfirst.frc.team6352.robot.OI;
import org.usfirst.frc.team6352.robot.RobotMap;
import org.usfirst.frc.team6352.robot.commands.CloseGearHolder;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem
{
	Servo servo;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public GearHolder()
	{
		servo = new Servo(RobotMap.gearHolderChannel);
	}
	
	public void setPosition(double position)
	{
		servo.setPosition(position);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand(new CloseGearHolder(OI.dashboardGearHolderClosed));
	}
}
