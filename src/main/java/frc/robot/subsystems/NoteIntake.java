package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import com.ctre.phoenix.motorcontrol.InvertType;

public class NoteIntake extends SubsystemBase {
    public final WPI_TalonSRX intakeMotor1 = new WPI_TalonSRX(Constants.MotorPorts.IntakeMotorPort);
    public final WPI_VictorSPX intakeMotor2 = new WPI_VictorSPX(Constants.MotorPorts.IntakeMotor2Port);
    public final WPI_VictorSPX shooterMotor1 = new WPI_VictorSPX(Constants.MotorPorts.ShooterMotorPort);
    public final WPI_VictorSPX shooterMotor2 = new WPI_VictorSPX(Constants.MotorPorts.ShooterMotor2Port);
    public final WPI_TalonSRX middleMotor = new WPI_TalonSRX(Constants.MotorPorts.middleMotorPort);

    

        //float (decimal value) value is for the motor controller where 1= 100%  foward, -1 backwards, 0 is off
public void IntakeNote(float speed){
    intakeMotor1.set(speed);
    intakeMotor2.set(speed);
    middleMotor.set(speed);
    intakeMotor1.setInverted(false);
    intakeMotor2.setInverted(false);
    middleMotor.setInverted(false);

}


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}