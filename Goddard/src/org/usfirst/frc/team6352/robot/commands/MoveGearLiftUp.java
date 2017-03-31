package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.OI;

/**
 * A command for moving the gear lift up.
 */
public class MoveGearLiftUp extends MoveGearLift
{
	public MoveGearLiftUp()
	{
		super(OI.dashboardGearLiftSpeedUp, OI.dashboardGearLiftTimeout);
	}
}
