package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends InstantCommand {

    private final DriveSubsystem m_subsystem;
    private final int m_time; // In milleseconds
    private int currentTime = 0;

    public AutoCommand(DriveSubsystem subsystem, int time) {
        m_subsystem = subsystem;
        m_time = time;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentTime = 0;
  }

  @Override
  public void execute() {
    m_subsystem.tankDrive(1,1);
    while(currentTime < m_time){
      break;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return currentTime >= m_time;
  }
    
}
