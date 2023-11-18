package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardCommand extends CommandBase {
    private DriveSubsystem driveTrain;
    private double speed;

    public DriveForwardCommand(DriveSubsystem driveTrain, double speed) {
        this.driveTrain = driveTrain;
        this.speed = speed;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.moveForward(speed);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}