package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    private CANSparkMax leftElevatorMotor;
    private CANSparkMax rightElevatorMotor;

    public ElevatorSubsystem() {
        leftElevatorMotor = new CANSparkMax(5, MotorType.kBrushless);
        rightElevatorMotor = new CANSparkMax(6, MotorType.kBrushless);
    }

    public void setSpeed(double speed) {
        leftElevatorMotor.set(speed);
        rightElevatorMotor.set(speed);
    }

    public void stop() {
        setSpeed(0);
    }
}
