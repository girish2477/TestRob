package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class LowerElevatorCommand extends CommandBase {

    private final ElevatorSubsystem elevatorSubsystem;
   
    public LowerElevatorCommand(ElevatorSubsystem elevatorSubsystem) {
       this.elevatorSubsystem = elevatorSubsystem;
       addRequirements(elevatorSubsystem);
    }
   
    @Override
    public void execute() {
       elevatorSubsystem.setSpeed(-1);
    }
   
    @Override
    public void end(boolean interrupted) {
       elevatorSubsystem.stop();
    }
   }