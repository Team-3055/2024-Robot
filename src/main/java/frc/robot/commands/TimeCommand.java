package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

public class TimeCommand extends InstantCommand {

    private final double chosenTime = AutoCommand.m_time;
    private final DriveSubsystem m_robotDrive = new DriveSubsystem();


    public TimeCommand() {
        
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    AutoCommand.currentTime += 1;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_robotDrive.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return AutoCommand.currentTime >= chosenTime;
  }
    
}
