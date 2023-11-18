package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class CheckAngleCommand extends CommandBase {
    private final GyroSubsystem gyroSubsystem;
    private final ElevatorSubsystem elevatorSubsystem;
    private final double targetAngle;

    public CheckAngleCommand(GyroSubsystem gyroSubsystem, ElevatorSubsystem elevatorSubsystem, double targetAngle) {
        this.gyroSubsystem = gyroSubsystem;
        this.elevatorSubsystem = elevatorSubsystem;
        this.targetAngle = targetAngle;
        addRequirements(gyroSubsystem);
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        System.out.println("In CheckAngleCommand");
        if (Math.abs(gyroSubsystem.getAngle() - targetAngle) < 1.0) { // Assumes a tolerance of 1 degree
            System.out.println("In targetAngle < 1.0");
            elevatorSubsystem.setSpeed(targetAngle);
            SmartDashboard.putBoolean("At Target Angle", true);
        } else {
            System.out.println("In targetAngle > 1.0");
            SmartDashboard.putBoolean("At Target Angle", false);
        }
    }
}