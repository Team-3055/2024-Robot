package frc.robot.commands;


// import java.io.Console;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends InstantCommand {

    private final DriveSubsystem m_subsystem;
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
    timeIt++;
    if(timeIt >= 100 && timeIt <= 500){
      m_subsystem.tankDrive(0.5,0.5);
      //new TimeCommand().withTimeout(1);
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
    System.out.println("!!!!!!!!!!AUTONOMOUS ENDED HERE!!!!!!!!!!!!");
    timeIt = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return currentTime >= m_time;
  }
    
}

/* mine
 * return timeIt <= m_time;
 * 
 * m_subsystem.tankDrive(0, 0);
    System.out.println("!!!!!!!!!!AUTONOMOUS ENDED HERE!!!!!!!!!!!!");
    timeIt = 0;

     //System.out.println(timeIt);
    timeIt++;
    if(timeIt <= 500){
      m_subsystem.tankDrive(0.5,0.5);
   }

   m_subsystem = subsystem;
        m_time = time*50;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
 */

 /* Lium's
  * 
  //System.out.println(timeIt);
    timeIt++;
    if(timeIt >= 100 && timeIt <= 500){
      m_subsystem.tankDrive(0.5,0.5);
      //new TimeCommand().withTimeout(1);
   }

    m_subsystem.tankDrive(0, 0);
    System.out.println("!!!!!!!!!!AUTONOMOUS ENDED HERE!!!!!!!!!!!!");
    timeIt = 0;

    return currentTime >= m_time;
  */