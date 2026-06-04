package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(Constants.MotorConfigurations.LEFT_MOTOR_1_PORT);
    private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(Constants.MotorConfigurations.LEFT_MOTOR_2_PORT);

    private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.MotorConfigurations.RIGHT_MOTOR_1_PORT);
    private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.MotorConfigurations.RIGHT_MOTOR_2_PORT);
    
    public DriveSubsystem(){
        leftMotor1.setInverted(Constants.MotorConfigurations.LEFT_MOTOR_INVERTED);
        leftMotor2.setInverted(Constants.MotorConfigurations.LEFT_MOTOR_INVERTED);
        rightMotor1.setInverted(Constants.MotorConfigurations.RIGHT_MOTOR_INVERTED);
        rightMotor2.setInverted(Constants.MotorConfigurations.RIGHT_MOTOR_INVERTED);

        leftMotor1.setNeutralMode(NeutralMode.Brake);
        leftMotor2.setNeutralMode(NeutralMode.Brake);
        rightMotor1.setNeutralMode(NeutralMode.Brake);
        rightMotor2.setNeutralMode(NeutralMode.Brake);

        leftMotor2.follow(leftMotor1);
        rightMotor2.follow(rightMotor1);
    }

    public void setDriveSpeed(double leftMotor, double rightMotor){
        leftMotor1.set(leftMotor);
        rightMotor1.set(rightMotor);
    }
}
