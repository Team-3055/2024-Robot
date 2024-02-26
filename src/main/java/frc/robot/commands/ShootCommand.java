package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.RobotConstants;
import frc.robot.subsystems.NoteIntake;

public class ShootCommand extends InstantCommand {

    private final NoteIntake m_subsystem;
    private static double m_shooter_speed_modifier;
    public ShootCommand(NoteIntake subsystem) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_shooter_speed_modifier = SmartDashboard.getNumber("Intake Speed", RobotConstants.intakeSpeed);
    m_subsystem.shooterMotor1.set(m_shooter_speed_modifier);
    m_subsystem.shooterMotor2.set(m_shooter_speed_modifier);
    m_subsystem.middleMotor.set(RobotConstants.intakeSpeed);
    m_subsystem.shooterMotor1.setInverted(false);
    m_subsystem.shooterMotor2.setInverted(false);
    m_subsystem.middleMotor.setInverted(true);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.shooterMotor1.set(0);
    m_subsystem.shooterMotor2.set(0);
    m_subsystem.middleMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}