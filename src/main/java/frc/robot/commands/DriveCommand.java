package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveCommand extends Command{
    public DriveCommand(){
        addRequirements(RobotContainer.driveSubsystem);
    }
    @Override
    public void execute(){
        //double rawForward = -RobotContainer.driverController.getLeftY();
        double forward = MathUtil.applyDeadband(-RobotContainer.driverController.getLeftY(), Constants.OperatorConstants.CONTROLLER_DEADBAND);
        double turn = MathUtil.applyDeadband(-RobotContainer.driverController.getRightX(), Constants.OperatorConstants.CONTROLLER_DEADBAND);

        forward = ((forward * forward) * Math.signum(forward)) * Constants.OperatorConstants.FORWARD_SPEED;
        turn = ((turn * turn) * Math.signum(turn)) * Constants.OperatorConstants.TURN_SPEED;

        double leftMotor = forward - turn;
        double rightMotor = forward + turn;

        RobotContainer.driveSubsystem.setDriveSpeed(leftMotor, rightMotor);
        //System.out.println("Raw Forward" + rawForward + "   |   " + "Forward" + forward);
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
