// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveForwardCommand;
import frc.robot.subsystems.DriveSubsystem;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  private XboxController controller;
  // public static CANSparkMax leftFront;
  // public static CANSparkMax leftRear;
  // public static CANSparkMax rightFront;
  // public static CANSparkMax rightRear;
  public static DifferentialDrive differentialDrive;
  //private DriveSubsystem driveSubsystem;

  @Override
  public void robotInit() {
    // leftFront = new CANSparkMax(1, MotorType.kBrushless);
    // leftRear = new CANSparkMax(2, MotorType.kBrushless);
    // rightFront = new CANSparkMax(3, MotorType.kBrushless);
    // rightRear = new CANSparkMax(4, MotorType.kBrushless);
    // differentialDrive = new DifferentialDrive(leftFront, rightFront);
    //driveSubsystem = new DriveSubsystem();
    m_robotContainer = new RobotContainer();
    // leftFront.setInverted(true); 
    // rightFront.setInverted(true); 

    controller = new XboxController(Constants.kControllerPort);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  int elapsedCycle;

  @Override
  public void autonomousPeriodic() {
    System.out.println(elapsedCycle * 0.02);
    elapsedCycle++;
    CommandScheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    // double throttle = -Constants.Joystick.LEFT_Y_AXIS; // Use the left joystick's Y-axis to control throttle
    // double turn = Constants.Joystick.RIGHT_X_AXIS; // Use the right joystick's X-axis to control turn
    // driveSubsystem.arcadeDrive(throttle, turn);
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {

  }

  @Override
  public void simulationPeriodic() {
  }
}
