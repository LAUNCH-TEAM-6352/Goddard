package org.usfirst.frc.team6352.robot.commands;

import org.usfirst.frc.team6352.robot.OI;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftFieldAuto extends CommandGroup {

    public LeftFieldAuto() 
    {
    
    	addSequential(new MoveGearLiftDown());
    	addSequential(new DriveAutonomous2(OI.dashboardAutoFwdSpeed, OI.dashboardAutoFwdSpeed, OI.dashboardAutoFwdTimeout));
    	addSequential(new DriveAutonomous2(OI.dashboardAutoTurnFwdSpeed, OI.dashboardAutoTurnRevSpeed, OI.dashboardAutoTurnTimeout));
    	addSequential(new DriveAutonomous2(OI.dashboardAutoFwdGearPegSpeed, OI.dashboardAutoFwdGearPegSpeed, OI.dashboardAutoFwdGearPegTimeout));
    	
    }
}
