package frc.robot.commands;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.InstantCommand;
//import frc.robot.Constants.MISCMotorConstants;
import frc.robot.subsystems.ArmHang;

public class RetractCommand extends InstantCommand {
    private final ArmHang m_subsystem;
    //private static DigitalInput bottomLimitSwitch = new DigitalInput(MISCMotorConstants.bottomLimitSwitch);

    public RetractCommand(ArmHang subsystem) {
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
    //if(bottomLimitSwitch.get() == false){
      
      m_subsystem.retractShooter();
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
