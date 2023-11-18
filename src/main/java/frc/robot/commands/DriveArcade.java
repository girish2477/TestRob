package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class DriveArcade extends CommandBase {
    public DriveArcade() {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(RobotContainer.driveSubsystem);
      }
    
      // Called just before this Command runs the first time
      @Override
    public void initialize() {
      }
    
      // Called repeatedly when this Command is scheduled to run
      @Override
    public void execute() {
        System.out.println("In DriveArcade Execute");
        double moveSpeed = -RobotContainer.driverController.getRawAxis(Constants.DriveConstants.DRIVER_CONTROLLER_MOVE_AXIS);
        double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.DriveConstants.DRIVER_CONTROLLER_ROTATE_AXIS);    
        System.out.println("In DriveArcade Execute - moveSpeed :"+ moveSpeed+", rotateSpeed:"+rotateSpeed);
        RobotContainer.driveSubsystem.arcadeDrive(moveSpeed, rotateSpeed);
      }
    
      // Called once the command ends or is interrupted.
      @Override
    public void end(boolean interrupted) {
        RobotContainer.driveSubsystem.arcadeDrive(0, 0);
      }
    
      // Make this return true when this Command no longer needs to run execute()
      @Override
    public boolean isFinished() {
        return false;
      }
}
