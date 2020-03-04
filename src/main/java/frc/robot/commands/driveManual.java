/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
 

public class driveManual extends Command {
  public driveManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double speed = Robot.oi.joy1.getRawAxis(3) - Robot.oi.joy1.getRawAxis(2);
    double rotation = Robot.oi.joy1.getRawAxis(0);
    boolean quickTurn = speed > -0.2 && speed < 0.2;

    if( speed > -0.2 && speed < 0.2);{
      speed = 0;
    }

    if(rotation > -0.2 && rotation < 0.2){
      rotation = 0;
    }
    
    Robot.driveTrain.driveCurvature(-speed, rotation, quickTurn);
  }

    

    // Use the Code below for arcadeDrive.  Comment out the code above.
    //double speed;
    //double rotation;
    //double left;
    //double right;
    
    //double speed = Robot.oi.getJoystick0().getRawAxis(1);
   //double rotation = Robot.oi.getJoystick0().getRawAxis(0);

 //double left = speed + rotation;
  //double right = speed - rotation;

    //RobotMap.driveTrainLeftMotorA.set(left);
    //RobotMap.driveTrainLeftMotorB.set(left);
    //RobotMap.driveTrainRightMotorA.set(-right);
    //RobotMap.driveTrainRightMotorB.set(-right);

    //Robot.driveTrain.driveArcade.(speed, rotation);
    //}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}