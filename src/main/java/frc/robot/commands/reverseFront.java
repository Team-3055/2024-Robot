package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

public class reverseFront extends InstantCommand {

    private final DriveSubsystem m_subsystem;
    private int callTime = 0;

    public reverseFront(DriveSubsystem subsystem) {
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
    // inverted means turn left
    // not inverted turns right
    if(m_subsystem.leftFrontMotor.getInverted() == true){
        m_subsystem.leftFrontMotor.setInverted(false);
        m_subsystem.rightFrontMotor.setInverted(true);
    } else {
        m_subsystem.leftFrontMotor.setInverted(true);
        m_subsystem.rightFrontMotor.setInverted(false);
    }

    callTime = 1;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return callTime == 1;
  }
    
} 
