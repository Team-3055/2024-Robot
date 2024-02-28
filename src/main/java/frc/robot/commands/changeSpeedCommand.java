package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.RobotConstants;

public class changeSpeedCommand extends InstantCommand {

    private int buttonNumber;

    public changeSpeedCommand(int buttonNum) {
        buttonNumber = buttonNum;
    }

     // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(buttonNumber==11){
        RobotConstants.intakeSpeed -= 0.05;
    }
    if(buttonNumber==12){
        RobotConstants.intakeSpeed += 0.05;
    }
    if(buttonNumber==9){
        RobotConstants.shooterSpeed -= 0.05;
    }
    if(buttonNumber==10){
        RobotConstants.shooterSpeed += 0.05;
    }
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
