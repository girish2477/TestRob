// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax leftFront, leftRear, rightFront, rightRear;
  private DifferentialDrive differentialDrive;

  public DriveSubsystem() {
    leftFront = new CANSparkMax(1, MotorType.kBrushless);
    leftRear = new CANSparkMax(2, MotorType.kBrushless);
    rightFront = new CANSparkMax(3, MotorType.kBrushless);
    rightRear = new CANSparkMax(4, MotorType.kBrushless);    

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
