/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
// you need to install CTRE pheonix in online libraries


import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    // The motors on the left side of the drive.
    /*private final SpeedControllerGroup leftMotors = 
        new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.kLeftMotor1Port),
                                new WPI_TalonSRX(DriveConstants.kLeftMotor2Port));

    // The motors on the right side of the drive.
    private final SpeedControllerGroup rightMotors = 
        new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.kRightMotor1Port),
                                new WPI_TalonSRX(DriveConstants.kRightMotor2Port));
   */

    private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(DriveConstants.kLeftMotor1Port);
    private final WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(DriveConstants.kLeftMotor2Port);
    private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(DriveConstants.kRightMotor1Port);
    private final WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(DriveConstants.kRightMotor2Port);

     // The robot's drive
    private final DifferentialDrive t_drive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
    
    //public DriveSubsystem() {
    //}
  
    /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
      /**
   * Drives the robot using Tank controls.
   *
   * @param leftspeed left motor output
   * @param rightspeed right motor output
   */
    public void tankDrive(double leftSpeed, double rightSpeed){
      t_drive.tankDrive(leftSpeed, rightSpeed);
      leftRearMotor.follow(leftFrontMotor);
      rightRearMotor.follow(rightFrontMotor);
      leftFrontMotor.setInverted(true);
      rightFrontMotor.setInverted(false);
      leftRearMotor.setInverted(InvertType.FollowMaster);
      rightRearMotor.setInverted(InvertType.FollowMaster);
    }
    
    /**
    * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
    *
    * @param maxOutput the maximum output to which the drive will be constrained
    */
    public void setMaxOutput(double maxOutput) {
        t_drive.setMaxOutput(maxOutput);
        }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
