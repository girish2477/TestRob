// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax leftFront, leftRear, rightFront, rightRear;
  private DifferentialDrive differentialDrive;

  public DriveSubsystem() {
    leftFront = new CANSparkMax(Constants.DriveConstants.DRIVESUBSYS_LEFT_FRONT, MotorType.kBrushless);
    leftRear = new CANSparkMax(Constants.DriveConstants.DRIVESUBSYS_LEFT_REAR, MotorType.kBrushless);
    rightFront = new CANSparkMax(Constants.DriveConstants.DRIVESUBSYS_RIGHT_FRONT, MotorType.kBrushless);
    rightRear = new CANSparkMax(Constants.DriveConstants.DRIVESUBSYS_RIGHT_REAR, MotorType.kBrushless);
    leftRear.follow(leftFront);
    rightRear.follow(rightFront);
    differentialDrive = new DifferentialDrive(leftFront, rightFront);
  }

  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

  public void moveForward(double speed) {
    differentialDrive.arcadeDrive(speed, 0);
  }

  public void moveBackward(double speed) {
    differentialDrive.arcadeDrive(-speed, 0);
  }

  public void moveLeft(double speed) {
    differentialDrive.arcadeDrive(0, speed);
  }

  public void moveRight(double speed) {
    differentialDrive.arcadeDrive(0, -speed);
  }

  // public void elevatorUp(double speed) {
  //   elevator.set(speed);
  // }

  // public void elevatorDown(double speed) {
  //   elevator.set(-speed);
  // }

  // public void elevatorStop() {
  //   elevator.set(0);
  // }

  public void stop() {
    differentialDrive.arcadeDrive(0, 0);
  }
}
