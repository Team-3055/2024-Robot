package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmHang extends SubsystemBase {
    private WPI_VictorSPX shooterMotor = new WPI_VictorSPX(Constants.MotorPorts.ArmHangHydrolicPort);
    private WPI_TalonSRX hookMotor = new WPI_TalonSRX(Constants.MotorPorts.hookAccutatorPort);

    public void extendShooter() {
        shooterMotor.set(-Constants.RobotConstants.shooterMoveSpeed); // Set the motor speed to 1 to extend the hydraulic system.
    }

    public void retractShooter() {
        shooterMotor.set(Constants.RobotConstants.shooterMoveSpeed); // Set the motor speed to -1 to retract the hydraulic system.   
    }

    public void stopShooter() {
        shooterMotor.set(0); // Set the motor speed to 0 to stop the hydraulic system.
    }
    
    public void extendHook() {
        hookMotor.set(Constants.RobotConstants.hookMoveSpeed); // Set the motor speed to 1 to extend the hydraulic system.
    }

    public void retractHook() {
        hookMotor.set(-Constants.RobotConstants.hookMoveSpeed); // Set the motor speed to -1 to retract the hydraulic system.
    }

    public void stopHook() {
        hookMotor.set(0); // Set the motor speed to 0 to stop the hydraulic system.
    }
}
