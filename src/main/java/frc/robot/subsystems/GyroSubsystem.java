package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private PigeonIMU gyro;

    public GyroSubsystem() {
        gyro = new PigeonIMU(0); // Assumes Pigeon is on CAN ID 0
    }

    public double getAngle() {
        double[] ypr = new double[3];
        gyro.getYawPitchRoll(ypr);
        return ypr[0]; // Returns the Yaw
    }
}

