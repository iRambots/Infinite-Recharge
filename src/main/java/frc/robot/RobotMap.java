/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.Spark;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
  public static AHRS ahrs;

  // Define 'LEFT' Motors

  public static WPI_VictorSPX driveTrainLeftMotorA;
  public static WPI_VictorSPX driveTrainLeftMotorB;

  // Define Speed Controller Group for 'LEFT Motors

  public static SpeedControllerGroup driveTrainLeftMotors;

  // Define 'RIGHT' Motors

  public static WPI_VictorSPX driveTrainRightMotorA;
  public static WPI_VictorSPX driveTrainRightMotorB;

  // Define Speed Controller Group for 'RIGHT' Motors

  public static SpeedControllerGroup driveTrainRightMotors;

  // Define Differential Drive

  public static DifferentialDrive driveTrainDifferentialDrive;

  public static WPI_VictorSPX rollerMotor;
  public static WPI_VictorSPX liftMotor;
  public static WPI_VictorSPX armMotor;

  public static void init() {

    ahrs = new AHRS(SerialPort.Port.kMXP);

   
    

 
    


    // Define the ports the 'LEFT' Motor Controllers are Connected to the RoboRIO
    // (CAN or PWM) If CAN additional steps are required to set address port on
    // Motor Controller

   

// For Victor SPX
    driveTrainLeftMotorA = new WPI_VictorSPX(1);
    driveTrainLeftMotorB = new WPI_VictorSPX(2);


//Define what motors are part of the 'LEFT' Speed Controller Group  
  driveTrainLeftMotors = new SpeedControllerGroup(driveTrainLeftMotorA, driveTrainLeftMotorB/*, driveTrainLeftMotorC*/);


  //For Victor SPX
    driveTrainRightMotorA = new WPI_VictorSPX(3);
    driveTrainRightMotorB = new WPI_VictorSPX(4);

  // Define the ports the 'RIGHT' Motor Controllers are Connected to the RoboRIO (CAN or PWM)  If CAN additional steps are required to set address port on Motor Controller

//Define what motors are part of the 'RIGHT' Speed Controller Group  
  driveTrainRightMotors = new SpeedControllerGroup(driveTrainRightMotorA, driveTrainRightMotorB/*, driveTrainRightMotorC*/);

//Define what Speed Controller Groups are part of the Differential Drive
  driveTrainDifferentialDrive = new DifferentialDrive(driveTrainLeftMotors, driveTrainRightMotors);



//Define what motors are part of the energy cell roller
  rollerMotor = new WPI_VictorSPX(6);

//Define what motors are part of the Lift Motor
  liftMotor = new WPI_VictorSPX(5);

//Define what motors are part of the Arm motor. 
  armMotor = new WPI_VictorSPX(7);
 


//Define Options for Differential Drive
  driveTrainDifferentialDrive.setSafetyEnabled(false);
  driveTrainDifferentialDrive.setExpiration(0.1);
  driveTrainDifferentialDrive.setMaxOutput(1.0);   //You can set the power output by changing (1.0 is most power and .1 is much less power)


/**
 * This is a demo program providing a real-time display of navX
 * MXP values.
 *
 * In the operatorControl() method, all data from the navX sensor is retrieved
 * and output to the SmartDashboard.
 *
 * The output data values include:
 *
 * - Yaw, Pitch and Roll angles
 * - Compass Heading and 9-Axis Fused Heading (requires Magnetometer calibration)
 * - Linear Acceleration Data
 * - Motion Indicators
 * - Estimated Velocity and Displacement
 * - Quaternion Data
 * - Raw Gyro, Accelerometer and Magnetometer Data
 *
 * As well, Board Information is also retrieved; this can be useful for debugging
 * connectivity issues after initial installation of the navX MXP sensor.
 *
 */

   /* Display 6-axis Processed Angle Data                                      */
 SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.ahrs.isConnected());
 SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.ahrs.isCalibrating());
 SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.ahrs.getYaw());
 SmartDashboard.putNumber(   "IMU_Pitch",            RobotMap.ahrs.getPitch());
 SmartDashboard.putNumber(   "IMU_Roll",             RobotMap.ahrs.getRoll());
 
 /* Display tilt-corrected, Magnetometer-based heading (requires             */
 /* magnetometer calibration to be useful)                                   */
 
 SmartDashboard.putNumber(   "IMU_CompassHeading",   RobotMap.ahrs.getCompassHeading());
 
 /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
 SmartDashboard.putNumber(   "IMU_FusedHeading",     RobotMap.ahrs.getFusedHeading());

 /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
 /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
 
 SmartDashboard.putNumber(   "IMU_TotalYaw",         RobotMap.ahrs.getAngle());
 SmartDashboard.putNumber(   "IMU_YawRateDPS",       RobotMap.ahrs.getRate());

 /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
 
 SmartDashboard.putNumber(   "IMU_Accel_X",          RobotMap.ahrs.getWorldLinearAccelX());
 SmartDashboard.putNumber(   "IMU_Accel_Y",          RobotMap.ahrs.getWorldLinearAccelY());
 SmartDashboard.putBoolean(  "IMU_IsMoving",         RobotMap.ahrs.isMoving());
 SmartDashboard.putBoolean(  "IMU_IsRotating",       RobotMap.ahrs.isRotating());

 /* Display estimates of velocity/displacement.  Note that these values are  */
 /* not expected to be accurate enough for estimating robot position on a    */
 /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
 /* of these errors due to single (velocity) integration and especially      */
 /* double (displacement) integration.                                       */
 
 SmartDashboard.putNumber(   "Velocity_X",           RobotMap.ahrs.getVelocityX());
 SmartDashboard.putNumber(   "Velocity_Y",           RobotMap.ahrs.getVelocityY());
 SmartDashboard.putNumber(   "Displacement_X",       RobotMap.ahrs.getDisplacementX());
 SmartDashboard.putNumber(   "Displacement_Y",       RobotMap.ahrs.getDisplacementY());
 
 /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
 /* NOTE:  These values are not normally necessary, but are made available   */
 /* for advanced users.  Before using this data, please consider whether     */
 /* the processed data (see above) will suit your needs.                     */
 
 SmartDashboard.putNumber(   "RawGyro_X",            RobotMap.ahrs.getRawGyroX());
 SmartDashboard.putNumber(   "RawGyro_Y",            RobotMap.ahrs.getRawGyroY());
 SmartDashboard.putNumber(   "RawGyro_Z",            RobotMap.ahrs.getRawGyroZ());
 SmartDashboard.putNumber(   "RawAccel_X",           RobotMap.ahrs.getRawAccelX());
 SmartDashboard.putNumber(   "RawAccel_Y",           RobotMap.ahrs.getRawAccelY());
 SmartDashboard.putNumber(   "RawAccel_Z",           RobotMap.ahrs.getRawAccelZ());
 SmartDashboard.putNumber(   "RawMag_X",             RobotMap.ahrs.getRawMagX());
 SmartDashboard.putNumber(   "RawMag_Y",             RobotMap.ahrs.getRawMagY());
 SmartDashboard.putNumber(   "RawMag_Z",             RobotMap.ahrs.getRawMagZ());
 SmartDashboard.putNumber(   "IMU_Temp_C",           RobotMap.ahrs.getTempC());
 SmartDashboard.putNumber(   "IMU_Timestamp",        RobotMap.ahrs.getLastSensorTimestamp());
 
 /* Omnimount Yaw Axis Information                                           */
 /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
 final AHRS.BoardYawAxis yaw_axis = RobotMap.ahrs.getBoardYawAxis();
 SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
 SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
 
 /* Sensor Board Information                                                 */
 SmartDashboard.putString(   "FirmwareVersion",      RobotMap.ahrs.getFirmwareVersion());
 
 /* Quaternion Data                                                          */
 /* Quaternions are fascinating, and are the most compact representation of  */
 /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
 /* from the Quaternions.  If interested in motion processing, knowledge of  */
 /* Quaternions is highly recommended.                                       */
 SmartDashboard.putNumber(   "QuaternionW",          RobotMap.ahrs.getQuaternionW());
 SmartDashboard.putNumber(   "QuaternionX",          RobotMap.ahrs.getQuaternionX());
 SmartDashboard.putNumber(   "QuaternionY",          RobotMap.ahrs.getQuaternionY());
 SmartDashboard.putNumber(   "QuaternionZ",          RobotMap.ahrs.getQuaternionZ());
 
 /* Connectivity Debugging Support                                           */
 SmartDashboard.putNumber(   "IMU_Byte_Count",       RobotMap.ahrs.getByteCount());
 SmartDashboard.putNumber(   "IMU_Update_Count",     RobotMap.ahrs.getUpdateCount());

 
  }


}