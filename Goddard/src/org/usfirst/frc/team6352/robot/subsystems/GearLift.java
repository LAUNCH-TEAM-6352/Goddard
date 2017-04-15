package org.usfirst.frc.team6352.robot.subsystems;

import org.usfirst.frc.team6352.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem for the gear lifter.
 */
public class GearLift extends Subsystem
{
	SpeedController motor;
	
	AnalogTrigger encoder;
	Counter counter;
	
	public GearLift()
	{
		motor = RobotMap.isCompetitionRobot
			? new Spark(RobotMap.gearLiftChannel)
			: new Victor(RobotMap.gearLiftChannel);
			
		encoder = new AnalogTrigger(RobotMap.gearLiftEncoderChannel);
		encoder.setLimitsVoltage(3.5, 5.0);
		counter = new Counter(encoder);
	}
			
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
//		 setDefaultCommand(new MySpecialCommand());
	}
	
	public void resetEncoderCounter()
	{
		counter.reset();
	}
	
	public int getEncoderCounter()
	{
		return counter.get();
	}
	
	public void setSpeed(double speed)
	{
		motor.set(speed);
	}
	
	public void stop()
	{
		motor.set(0);
	}
}
