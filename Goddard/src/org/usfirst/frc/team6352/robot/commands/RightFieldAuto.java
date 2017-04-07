package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.OI;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightFieldAuto extends CommandGroup {

    public RightFieldAuto() 
    {
    
    	addSequential(new DriveAutonomous2(OI.dashboardAutoFwdSpeed, OI.dashboardAutoFwdSpeed, OI.dashboardAutoFwdTimeout));
    	addSequential(new DriveAutonomous2(OI.dashboardAutoTurnRevSpeed, OI.dashboardAutoTurnFwdSpeed, OI.dashboardAutoTurnTimeout));
    	
    }
}
