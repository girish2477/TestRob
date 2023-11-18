// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    public static final int DRIVESUBSYS_LEFT_FRONT = 0;
    public static final int DRIVESUBSYS_LEFT_REAR = 1;
    public static final int DRIVESUBSYS_RIGHT_FRONT = 2;
    public static final int DRIVESUBSYS_RIGHT_REAR = 3;
    // Joysticks
    public static final int DRIVER_CONTROLLER = 0;
    public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1; // Change for your controller
    public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2; // Change for your controller

    public static final int kLeftMotor1Port = 0;
    public static final int kLeftMotor2Port = 1;
    public static final int kRightMotor1Port = 2;
    public static final int kRightMotor2Port = 3;

    public static final int[] kLeftEncoderPorts = new int[] { 0, 1 };
    public static final int[] kRightEncoderPorts = new int[] { 2, 3 };
    public static final boolean kLeftEncoderReversed = false;
    public static final boolean kRightEncoderReversed = true;

    public static final double kTrackwidthMeters = 0.69;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
        kTrackwidthMeters);

    public static final int kEncoderCPR = 1024;
    public static final double kWheelDiameterMeters = 0.15;
    public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
        (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;

    // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    // These characterization values MUST be determined either experimentally or
    // theoretically
    // for *your* robot's drive.
    // The Robot Characterization Toolsuite provides a convenient tool for obtaining
    // these
    // values for your robot.
    public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;

    // Example value only - as above, this must be tuned for your drive!
    public static final double kPDriveVel = 8.5;
  }

  public static final class ElevatorConstants {
    public static final int ELEVATORSUBSYS_LEFT_MOTOR = 4;
    public static final int ELEVATORSUBSYS_RIGHT_MOTOR = 5;
    public static final int RAISE_SPEED = 5;
    public static final int LOWER_SPEED = 6;
    public static final int RAISE_BUTTON_ID  =1;
    public static final int LOWER_BUTTON_ID=2;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;

    // Reasonable baseline values for a RAMSETE follower in units of meters and
    // seconds
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;
  }

  public static class Joystick {
    public static final int LEFT_Y_AXIS = 1;
    public static final int RIGHT_X_AXIS = 4;
  }

  public static final int kControllerPort = 0;

  public static final class Controller {
    public static final int kLeftHand = XboxController.Axis.kLeftX.value;
    public static final int kRightHand = XboxController.Axis.kRightX.value;
    public static final int kXboxButtonA = 1;
    public static final int kXboxButtonB = 2;
    public static final int kXboxButtonX = 3;
    public static final int kXboxButtonY = 4;
    public static final int kXboxLeftBumper = 5;
    public static final int kXboxRightBumper = 6;
    public static final int kXboxLeftStick = 9;
    public static final int kXboxRightStick = 10;
    public static final int kXboxSelect = 7;
    public static final int kXboxStart = 8;
    // Example values for joystick axis (assumes joystick axis is between -1 and 1)
    public static final double kJoystickDeadband = 0.1; // Ignore values less than this to avoid minor movement
  }
}