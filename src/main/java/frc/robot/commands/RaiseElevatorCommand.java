package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
public class RaiseElevatorCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;

 public RaiseElevatorCommand(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);
 }

 @Override
 public void execute() {
   System.out.println("In RaiseElevatorCommand");
    elevatorSubsystem.setSpeed(1);
 }

 @Override
 public void end(boolean interrupted) {
    elevatorSubsystem.stop();
 }
}

