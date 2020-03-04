/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class liftVert extends Command {
    //@SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    public liftVert() {
      //Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
      requires(Robot.lift);
    }
    
    @Override
    protected void initialize(){
    }

    @Override
    protected void execute() {
        Robot.lift.liftUp();
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.lift.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

    }
    