package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.NoteIntake;

public class ShootCommand extends InstantCommand {

    private final NoteIntake m_subsystem;

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
    m_subsystem.shooterMotor1.set(1);
    m_subsystem.shooterMotor2.set(1);
    m_subsystem.shooterMotor1.setInverted(false);
    m_subsystem.shooterMotor2.setInverted(false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.shooterMotor1.set(0);
    m_subsystem.shooterMotor2.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}