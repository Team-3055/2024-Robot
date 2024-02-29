package frc.robot.commands;


// import java.io.Console;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NoteIntake;

public class AutoCommand extends InstantCommand {

    public final DriveSubsystem m_subsystem;
    public final NoteIntake m_intake = new NoteIntake();
    public static double m_time; // in seconds
    public static double currentTime = 0.0;
    public int timeIt = 0;

    public AutoCommand(DriveSubsystem subsystem, double time) {
        m_subsystem = subsystem;
        m_time = time;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
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
    if(timeIt >= 100 && timeIt <= 400){
      m_subsystem.tankDrive(1,1, 0.5);
   }
   if(timeIt >= 200 && timeIt <= 300){
      new ShootCommand(m_intake);
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0, 1);
    System.out.println("!!!!!!!!!!AUTONOMOUS ENDED HERE!!!!!!!!!!!!");
    timeIt = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return currentTime >= m_time;
  }    
}