// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.Constants.RobotConstants;
//import frc.robot.Constants.RobotConstants;
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TankDrive;
import frc.robot.commands.changeSpeedCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.NoteIntake;
import frc.robot.subsystems.ArmHang;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.Robot;
import edu.wpi.first.wpilibj.PowerDistribution;
//import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
//mport edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.ExtendCommand;
import frc.robot.commands.RetractCommand;
import frc.robot.commands.ReverseIntake;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.ShootAndIntakeCommand;
import frc.robot.commands.ExtendHookCommand;
import frc.robot.commands.RetractHookCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  // import each subsystem
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final NoteIntake m_intake = new NoteIntake();
  private final ArmHang m_armHang = new ArmHang();
  private PowerDistribution m_distribution = new PowerDistribution();

  private ShuffleboardTab autoTab = Shuffleboard.getTab("Auto Select");
  private GenericEntry autoSelect = autoTab.add("auto_Select", 0).getEntry();

  public static int driveInverted = 1;
  public static int autoNumber = 1;
 
  // Replace with CommandPS4Controller or CommandJoystick if needed
  //Joystick m_driverLJoystick = new Joystick(OIConstants.kLeftJoystickPort);
  Joystick m_driverRJoystick = new Joystick(OIConstants.kRightJoystickPort);
  
  private final XboxController m_driverController = 
    new XboxController(OIConstants.kXboxControllerPort);
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new TankDrive(
            m_robotDrive,
            () -> (driveInverted == -1? m_driverController.getRightY() : m_driverController.getLeftY()),
            () -> (driveInverted == -1? m_driverController.getLeftY() : m_driverController.getRightY()),
            () -> (driveInverted * ((-m_driverRJoystick.getThrottle() * 0.25) + 0.75))));
    }
  

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new Trigger(m_exampleSubsystem::exampleCondition)
       // .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value)
        .whileTrue(new ReverseIntake(m_intake));

    new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value)
        .whileTrue(new IntakeCommand(m_intake));

    new JoystickButton(m_driverRJoystick, 2)
        .whileTrue(new ShootCommand(m_intake));

    new JoystickButton(m_driverRJoystick, 1)
        .whileTrue(new ShootAndIntakeCommand(m_intake));
    
    new JoystickButton(m_driverRJoystick, 3)
        .whileTrue(new RetractCommand(m_armHang));
  
    new JoystickButton(m_driverRJoystick,5)
        .whileTrue(new ExtendCommand(m_armHang)); 

    new JoystickButton(m_driverRJoystick, 6)
        .whileTrue(new ExtendHookCommand(m_armHang));
    
    new JoystickButton(m_driverRJoystick, 4)
        .whileTrue(new RetractHookCommand(m_armHang));

    new JoystickButton(m_driverRJoystick, 11)
        .onTrue(new changeSpeedCommand(11));

    new JoystickButton(m_driverRJoystick, 12)
        .onTrue(new changeSpeedCommand(12));
    
    new JoystickButton(m_driverRJoystick, 9)
        .onTrue(new changeSpeedCommand(9));
    
    new JoystickButton(m_driverRJoystick, 10)
        .onTrue(new changeSpeedCommand(10));

    new POVButton(m_driverController, 0)
        .onTrue(new InstantCommand(() -> {driveInverted = -driveInverted;}));
      
    /*if(driveInverted == false){
      new POVButton(m_driverController, 0)
        .onTrue(new InstantCommand(() -> {driveInverted = true;}));
    }

    if(driveInverted == true){
      new POVButton(m_driverController, 0)
        .onTrue(new InstantCommand(() -> {driveInverted = false;}));
    }
    */

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new AutoCommand(m_robotDrive, m_intake, autoSelect.getDouble(0)); // time in seconds
  }
  public void updateSmartDashboard(){
    SmartDashboard.putData("PDP panel", m_distribution);
    SmartDashboard.putData("Drive motors", m_robotDrive);
    SmartDashboard.putNumber("Robot Speed", (driveInverted * ((-m_driverRJoystick.getThrottle() * 0.25) + 0.75)));
    SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
    SmartDashboard.putNumber("Shooter Speed", RobotConstants.shooterSpeed);
    SmartDashboard.putNumber("Intake Speed", RobotConstants.intakeSpeed);

    //dashboard commands
    
    
  }
  public void initSmartDashboard(){
    SmartDashboard.putData("Arm: Up", new ExtendCommand(m_armHang));
    SmartDashboard.putData("Arm: Down", new RetractCommand(m_armHang));
    SmartDashboard.putData("Hook: Up", new ExtendHookCommand(m_armHang));
    SmartDashboard.putData("Hook Down", new RetractHookCommand(m_armHang));

    SmartDashboard.putData("Intake and Shoot", new ShootAndIntakeCommand(m_intake));
    SmartDashboard.putData("Shoot", new ShootCommand(m_intake));
    SmartDashboard.putData("Intake", new IntakeCommand(m_intake));
    
    SmartDashboard.putData("Forward",new TankDrive(m_robotDrive, () -> 1, () -> 1, () -> 0.5));
    SmartDashboard.putData("Backward",new TankDrive(m_robotDrive, () -> -1, () -> -1, () -> 0.5));
    SmartDashboard.putData("Left",new TankDrive(m_robotDrive, () -> 1, () -> -1, () -> 0.5));
    SmartDashboard.putData("Right",new TankDrive(m_robotDrive, () -> -1, () -> 1, () -> 0.5));
  }
}

