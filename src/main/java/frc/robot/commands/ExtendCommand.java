package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.ArmHang;
import frc.robot.Constants.MISCMotorConstants;

public class ExtendCommand extends InstantCommand {
    private final ArmHang m_subsystem;
    private static DigitalInput LimitSwitch = new DigitalInput(MISCMotorConstants.topLimitSwitch);

    public ExtendCommand(ArmHang subsystem) {
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
      //System.out.println(LimitSwitch.get());
      m_subsystem.extendShooter();
      System.out.println(LimitSwitch.get());
    //}
    //System.out.println(topLimitSwitch.get());
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
    /*
    System.out.println(LimitSwitch.get());
    if(LimitSwitch.get() == true){
      return false;
    }else{}
      return true;
      */
  }
  }
  
