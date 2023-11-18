package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class StopDrivingCommand extends CommandBase {
    private DriveSubsystem driveTrain;

    public StopDrivingCommand(DriveSubsystem driveTrain) {
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.stop();
    }
}