package frc.robot.OI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.DriveBackwardCommand;
import frc.robot.commands.DriveForwardCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.TurnLeftCommand;
import frc.robot.commands.TurnRightCommand;
import frc.robot.subsystems.DriveSubsystem;

public class OI {
    private XboxController controller;
    private DriveSubsystem driveTrain;

    public OI(DriveSubsystem driveTrain) {
        controller = new XboxController(Constants.kControllerPort);
        this.driveTrain = driveTrain;

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // Example command that will run whenever the 'A' button is pressed
        // controller.whenAButtonPressed(new InstantCommand(() -> System.out.println("A Button Pressed!"), driveTrain));
    }
    public double getDriverRawAxis(int axis) {
        return controller.getRawAxis(axis);
    }

    public boolean getDriverRawButton(int button) {
        return controller.getRawButton(button);
    }

    public double getDriverLeftY() {
        return controller.getRawAxis(Axis.kLeftY.value);
    }

    public double getDriverRightY() {
        return controller.getRawAxis(Axis.kRightY.value);
    }

    public Command getJoystickInput() {
        if (getDriverRawButton(Constants.Controller.kXboxButtonA)) {
            return new DriveForwardCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxButtonB)) {
            return new DriveBackwardCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxButtonX)) {
            return new TurnLeftCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxButtonY)) {
            return new TurnRightCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxLeftBumper)) {
            return new ElevatorUpCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxRightBumper)) {
            return new ElevatorDownCommand(driveTrain,.5);
        } 
        
        /*else if (getDriverRawButton(Constants.Controller.kXboxLeftStick)) {
            return new ClawOpenCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxRightStick)) {
            return new ClawCloseCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxSelect)) {
            return new CameraSwivelLeftCommand(driveTrain,.5);
        } else if (getDriverRawButton(Constants.Controller.kXboxStart)) {
            return new CameraSwivelRightCommand(driveTrain,.5);
        }*/
        return null;
    }
}