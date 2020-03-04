/*package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.driveManual;
import frc.robot.subsystems.driveTrain;

public class auto180 extends Command {

    private final driveTrain m_driveTrain;

    public auto180() {
        requires(Robot.driveTrain);

        setTimeout(10.0);
    }

    @Override
    protected void initialize() {
        RobotMap.ahrs.getRawGyroZ();  
        RobotMap.ahrs.reset();  
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveArcade(speed, rotation);
    }

    @Override
    protected boolean isFinished() {
        return RobotMap.getIMU_Roll () < -180 || isTimedOut();
    }

}
*/

