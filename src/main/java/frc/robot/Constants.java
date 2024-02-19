// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final class DriveConstants {
    public static final int kLeftMotor1Port = 2;
    public static final int kLeftMotor2Port = 3;
    public static final int kRightMotor1Port = 9;
    public static final int kRightMotor2Port = 4;
}
public static final class OIConstants {
    public static final int kRightJoystickPort = 2;
    public static final int kLeftJoystickPort = 1;
    public static final int kXboxControllerPort = 0;
    public static final int kXboxController2Port = 3;
    
    //Values of joystick button mapping
    public static final int kJoystickTrigger = 1;
    public static final int kJoystickTop = 2;
}
public static final class PNUConstants {
    //useless 2024
    public static final int kCompressor = 0;
    public static final int kSolenoid1 = 0;
    public static final int kSolenoid2 = 1;
    public static final int kSolenoid3 = 2;
}


public static final class MISCMotorConstants {
    //useless 2024
    public static final int kWheel = 5;
    public static final int kWinch1 = 7;
    public static final int kWinch2 = 11;
    public static final int kWinch3 = 1;
    public static final int kWinch4 = 8;
}


public static final class nIntakeConstants {
    //quite useless 
    public static final int kIntakeMotor = 9;
    public static final int kLaunchMotor1 = 6;
    public static final int kLaunchMotor2 = 4;
    public static final int kShooterMotor = 12;
}
public static final class MotorPorts{
    public static final int ArmHangHydrolicPort = 1;
    public static final int IntakeMotorPort = 10;
    public static final int IntakeMotor2Port = 8;
    public static final int ShooterMotorPort = 7;
    public static final int ShooterMotor2Port = 11;
    public static final int middleMotorPort = 5;
}
}
