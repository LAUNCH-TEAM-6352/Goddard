package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.OI;

/**
 * A command for moving the gear lift down.
 */
public class MoveGearLiftDown extends MoveGearLift
{
	public MoveGearLiftDown()
	{
		super(OI.dashboardGearLiftSpeedDown, OI.dashboardGearLiftTimeout);
	}
}
