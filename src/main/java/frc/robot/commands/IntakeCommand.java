package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.RobotConstants;
import frc.robot.subsystems.NoteIntake;
//import frc.robot.Constants;

public class IntakeCommand extends InstantCommand {
    private static double m_intake_speed_modifier;
    private final NoteIntake m_subsystem;
    
    public IntakeCommand(NoteIntake subsystem) {
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
    m_intake_speed_modifier = SmartDashboard.getNumber("Intake Speed", RobotConstants.intakeSpeed);
    m_subsystem.intakeMotor1.set(m_intake_speed_modifier);
    m_subsystem.intakeMotor2.set(m_intake_speed_modifier);
    m_subsystem.middleMotor.set(m_intake_speed_modifier);
    m_subsystem.intakeMotor1.setInverted(false);
    m_subsystem.intakeMotor2.setInverted(false);
    m_subsystem.middleMotor.setInverted(true);
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
