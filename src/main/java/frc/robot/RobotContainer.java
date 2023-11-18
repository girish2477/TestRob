// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autos;
import frc.robot.commands.LowerElevatorCommand;
import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class RobotContainer {

  private DriveSubsystem driveSubsystem;
  private ElevatorSubsystem elevatorSubsystem;
  private Command autoCommand;
  private final Joystick joystick = new Joystick(0);

  public RobotContainer() {
    driveSubsystem = new DriveSubsystem();
    autoCommand = new Autos(driveSubsystem, 10, 2);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    driveSubsystem.setDefaultCommand(
        new RunCommand(
            () -> driveSubsystem.arcadeDrive(joystick.getY(), joystick.getZ()),
            driveSubsystem));

    // Example: raise the elevator with the "A" button and lower it with the "B"
    // button    
    // new JoystickButton(joystick, 1).whenPressed(new RaiseElevatorCommand(elevatorSubsystem));
    // new JoystickButton(joystick, 2).whenPressed(new LowerElevatorCommand(elevatorSubsystem));
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }

}
