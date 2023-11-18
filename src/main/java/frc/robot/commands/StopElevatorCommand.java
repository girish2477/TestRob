package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
public class StopElevatorCommand extends CommandBase{
    private final ElevatorSubsystem elevatorSubsystem;

    public StopElevatorCommand(ElevatorSubsystem elevatorSubsystem) {
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        System.out.println("In StopElevatorCommand");
        elevatorSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
