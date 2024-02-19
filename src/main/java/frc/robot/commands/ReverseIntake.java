package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.NoteIntake;
//import frc.robot.Constants;

public class ReverseIntake extends InstantCommand {

    private final NoteIntake m_subsystem;

    public ReverseIntake(NoteIntake subsystem) {
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
    m_subsystem.intakeMotor1.set(-0.75);
    m_subsystem.intakeMotor2.set(-0.75);
    m_subsystem.middleMotor.set(-1);
    m_subsystem.intakeMotor1.setInverted(true);
    m_subsystem.intakeMotor2.setInverted(true);
    m_subsystem.middleMotor.setInverted(false);
;  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.intakeMotor1.set(0);
    m_subsystem.intakeMotor2.set(0);
    m_subsystem.middleMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
