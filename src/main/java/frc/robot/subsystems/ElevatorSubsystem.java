package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
    private CANSparkMax leftElevatorMotor;
    private CANSparkMax rightElevatorMotor;

    public ElevatorSubsystem() {
        leftElevatorMotor = new CANSparkMax(Constants.ElevatorConstants.ELEVATORSUBSYS_LEFT_MOTOR,
                MotorType.kBrushless);
        rightElevatorMotor = new CANSparkMax(Constants.ElevatorConstants.ELEVATORSUBSYS_RIGHT_MOTOR,
                MotorType.kBrushless);
    }

    public void setSpeed(double speed) {
        leftElevatorMotor.set(speed);
        rightElevatorMotor.set(speed);
    }

    public void stop() {
        setSpeed(0);
    }       
    
}
