// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.LowerElevatorCommand;
import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.commands.StopElevatorCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class RobotContainer {

  public static DriveSubsystem driveSubsystem;
  private ElevatorSubsystem elevatorSubsystem;
  private Command autoCommand;
  public static Joystick driverController = new Joystick(Constants.DriveConstants.DRIVER_CONTROLLER);

  public RobotContainer() {
    driveSubsystem = new DriveSubsystem();
    autoCommand = new Autos(driveSubsystem, 10, 2);
    driveSubsystem.setDefaultCommand(new DriveArcade());
    elevatorSubsystem = new ElevatorSubsystem();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // Map raise button
    new JoystickButton(driverController, Constants.ElevatorConstants.RAISE_BUTTON_ID)
    .whenPressed(new RaiseElevatorCommand(elevatorSubsystem))
    .whenReleased(new StopElevatorCommand(elevatorSubsystem));

// Map lower button
new JoystickButton(driverController, Constants.ElevatorConstants.LOWER_BUTTON_ID)
    .whenPressed(new LowerElevatorCommand(elevatorSubsystem))
    .whenReleased(new StopElevatorCommand(elevatorSubsystem));    
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }

}
