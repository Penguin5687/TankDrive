package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveCommand extends Command{
    public DriveCommand(){
        addRequirements(RobotContainer.driveSubsystem);
    }
    @Override
    public void execute(){
        double forward = -RobotContainer.driverController.getLeftY() * Constants.OperatorConstants.FORWARD_SPEED;
        double turn = -RobotContainer.driverController.getRightX() * Constants.OperatorConstants.TURN_SPEED;

        double leftMotor = forward - turn;
        double rightMotor = forward + turn;

        RobotContainer.driveSubsystem.setDriveSpeed(leftMotor, rightMotor);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        RobotContainer.driveSubsystem.setDriveSpeed(0, 0);
    }
}
