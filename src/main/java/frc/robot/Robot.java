// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  // private final CANSparkMax leftFront = new CANSparkMax(1, MotorType.kBrushless);
  // private final CANSparkMax leftRear = new CANSparkMax(2, MotorType.kBrushless);
  // private final CANSparkMax rightFront = new CANSparkMax(3, MotorType.kBrushless);
  // private final CANSparkMax rightRear = new CANSparkMax(4, MotorType.kBrushless);
  // private DifferentialDrive differentialDrive = new DifferentialDrive(leftFront, rightFront);

  @Override
  public void robotInit() {
    // leftRear.setInverted(true);
    // rightRear.setInverted(true);
    m_robotContainer = new RobotContainer();
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
    double throttle = -Constants.Joystick.LEFT_Y_AXIS; // Use the left joystick's Y-axis to control throttle
    double turn = Constants.Joystick.RIGHT_X_AXIS; // Use the right joystick's X-axis to control turn
    // Call the arcade drive method to control the robot
    //differentialDrive.arcadeDrive(throttle, turn);
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
