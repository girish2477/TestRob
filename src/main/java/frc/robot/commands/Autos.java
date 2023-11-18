// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class Autos extends CommandBase {
  private DriveSubsystem driveSubSystem;
  private double driveTime;
  private double turnTime;
  private Timer runTime;

  public Autos(DriveSubsystem subsystem, double driveTime, double turnTime) {
    this.driveSubSystem = subsystem;
    this.driveTime = driveTime;
    this.turnTime = turnTime;
    runTime= new Timer(); 
  }
  @Override
  public void initialize() {
    runTime.reset();
    runTime.start();
  }
  @Override
  public void execute() {
    if (runTime.get() < driveTime) {
      driveSubSystem.arcadeDrive(0.5, 0);
      System.out.println("Moving for 10 seconds"); 
    } else if (runTime.get() < driveTime + turnTime) {
      driveSubSystem.arcadeDrive(0, 0.5);
      System.out.println("Turning 90 degrees"); 
    } else {
      driveSubSystem.arcadeDrive(0, 0);
      System.out.println("Auto Done"); 
    }
  }
  @Override
  public boolean isFinished() {
    return runTime.get() > driveTime + turnTime; 
  }
  @Override
    public void end(boolean interrupted) {
        this.driveSubSystem.arcadeDrive(0, 0);
    }

}
