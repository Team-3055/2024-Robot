package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.VisionSystem;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToTarget extends InstantCommand {

    private final VisionSystem m_VisionSystem;
    private final DriveSubsystem m_DriveSubsystem;

    public TurnToTarget(VisionSystem visionSubsystem, DriveSubsystem driveSubsystem) {
        m_VisionSystem = visionSubsystem;
        m_DriveSubsystem = driveSubsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(visionSubsystem);
        addRequirements(driveSubsystem);
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double angleToTarget = m_VisionSystem.getAngle();

    m_DriveSubsystem.tankDrive(angleToTarget, -angleToTarget);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
