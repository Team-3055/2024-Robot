package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmHang extends SubsystemBase {

    private WPI_VictorSPX motor = new WPI_VictorSPX(Constants.MotorPorts.ArmHangHydrolicPort);

    public void extend() {
        motor.set(1); // Set the motor speed to 1 to extend the hydraulic system.
    }

    public void retract() {
        motor.set(-1); // Set the motor speed to -1 to retract the hydraulic system.
    }

    public void stop() {
        motor.set(0); // Set the motor speed to 0 to stop the hydraulic system.
    }
}
