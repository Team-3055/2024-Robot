package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandScheduler;

// import java.io.Console;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NoteIntake;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.ShootAndIntakeCommand;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//mport edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
//﻿11:30:04.641 AM
//The above stacktrace can help determine where the error occurred.  Warning at edu.wpi.first.wpilibj.RobotBase.runRobot(RobotBase.java:379): The robot program quit unexpectedly. This is usually due to a code error. Warning  1  The robot program quit unexpectedly. This is usually due to a code error.
//The above stacktrace can help determine where the error occurred.
//See https://wpilib.org/stacktrace for more information.  edu.wpi.first.wpilibj.RobotBase.runRobot(RobotBase.java:379)    	at frc.robot.Main.main(Main.java:23)  	at edu.wpi.first.wpilibj.RobotBase.startRobot(RobotBase.java:453)  	at edu.wpi.first.wpilibj.RobotBase.runRobot(RobotBase.java:365)  	at edu.wpi.first.wpilibj.TimedRobot.startCompetition(TimedRobot.java:131)  	at edu.wpi.first.wpilibj.IterativeRobotBase.loopFunc(IterativeRobotBase.java:345)  	at frc.robot.Robot.autonomousInit(Robot.java:77)  	at frc.robot.RobotContainer.getAutonomousCommand(RobotContainer.java:160)  	at frc.robot.commands.AutoCommand.<init>(AutoCommand.java:27)  	at edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab.add(ShuffleboardTab.java:68)  	at edu.wpi.first.wpilibj.shuffleboard.ContainerHelper.add(ContainerHelper.java:79)  	at edu.wpi.first.wpilibj.shuffleboard.ContainerHelper.add(ContainerHelper.java:85)  	at edu.wpi.first.wpilibj.shuffleboard.ContainerHelper.checkTitle(ContainerHelper.java:186)  Error at frc.robot.commands.AutoCommand.<init>(AutoCommand.java:27): Unhandled exception: java.lang.IllegalArgumentException: Title is already in use: autoSelect 

public class AutoCommand extends InstantCommand {
    public final DriveSubsystem m_subsystem;
    public final NoteIntake m_intake;
    public int timeIt = 0;
    public double m_auto_select;

    private static double shooterSpeed = 0.5;
    private static double intakeSpeed = 0.5;
    // 0 means no auto
    // 1 means first auto
    // etc.
    

    public AutoCommand(DriveSubsystem driveSubsystem, NoteIntake intakeSubsystem, Double autoSelector) {
        m_subsystem = driveSubsystem;
        m_intake = intakeSubsystem;
        m_auto_select = autoSelector;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(driveSubsystem);
        addRequirements(intakeSubsystem);
        //addRequirements(autoSelector);
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    //System.out.println(timeIt);
    // in autonomous tank drive is reversed
    // -1 is forward 1 is backward
    timeIt++;
    System.out.println(m_auto_select);

    if(m_auto_select == 0){
      //do nothing
    }
    if(m_auto_select == 1){ // run first auto
      if(timeIt >= 0 && timeIt <= 200){ // from second 0 to second 5 drive forward; run for 5 seconds
        m_subsystem.tankDrive(-1,-1, 0.5);
      }
    } 
    if(m_auto_select == 2){
      if(timeIt >= 0 && timeIt <= 100){ // from second 0 to second 5 drive forward; run for 5 seconds
        m_intake.shooterMotor1.set(shooterSpeed);
        m_intake.shooterMotor2.set(shooterSpeed);
      } 
      if(timeIt >= 100 && timeIt <= 200){ // from second 0 to second 5 drive forward; run for 5 seconds
        m_intake.shooterMotor1.set(shooterSpeed);
        m_intake.shooterMotor2.set(shooterSpeed);
        m_intake.middleMotor.set(intakeSpeed);
        m_intake.intakeMotor1.set(intakeSpeed);
        m_intake.intakeMotor2.set(intakeSpeed);
      }       
      if(timeIt >= 200 && timeIt <= 350);
        m_intake.shooterMotor1.set(0);
        m_intake.shooterMotor2.set(0);
        m_intake.middleMotor.set(0);
        m_intake.intakeMotor1.set(0);
        m_intake.intakeMotor2.set(0);
        m_subsystem.tankDrive(-1, -1, 0.5);
      }
    } 
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0, 1);
    //System.out.println("!!!!!!!!!!AUTONOMOUS ENDED HERE!!!!!!!!!!!!");
    timeIt = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }    
}