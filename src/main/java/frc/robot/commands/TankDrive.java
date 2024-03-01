/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class TankDrive extends Command {
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private final DoubleSupplier m_speed_modifier;
  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param left The control input for driving left motors
   * @param right The control input for driving right motors
   * @param speed_modifier speed modifer for drive system
   */
  public TankDrive(DriveSubsystem subsystem, DoubleSupplier left, DoubleSupplier right, DoubleSupplier speed_modifier) {
    m_drive = subsystem;
    m_left = left;
    m_right = right;
    m_speed_modifier = speed_modifier;
    addRequirements(m_drive);
    
  }

  @Override
  public void execute() {
    m_drive.tankDrive(m_left.getAsDouble(), m_right.getAsDouble(), m_speed_modifier.getAsDouble());
  }
}