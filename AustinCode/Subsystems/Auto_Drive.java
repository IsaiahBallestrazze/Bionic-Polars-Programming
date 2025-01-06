// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//swerve_no_g
package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake2;
import frc.robot.subsystems.drive;

public class Auto_Drive extends Command {

  private final drive s_drive;
  private final Intake2 intake1; 

private double headhold=0;
private double once=0;
private double degrees;
private double speed;
private double distance;
 

  /** Creates a new swervedrive. */
  public Auto_Drive(drive d_drive, Intake2 intake2, Double Degree, Double Speed, Double Distance) {

s_drive=d_drive;
degrees = Degree;
distance = Distance;
speed = Speed;
intake1 = intake2;
addRequirements(s_drive, intake1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


s_drive.swerve(degrees+s_drive.gyro180(), speed, 0,degrees);
intake1.ChamberSpeed(.75);

//outputs info for debuging. add // infront of paragrafe comment to enable
/*
SmartDashboard.putNumber("degrees", degrees);
SmartDashboard.putNumber("speed", speed);

SmartDashboard.putNumber("encoder1", s_drive.number1());
SmartDashboard.putNumber("encoder2", s_drive.number2());
SmartDashboard.putNumber("encoder3", s_drive.number3());
SmartDashboard.putNumber("encoder4", s_drive.number4());

SmartDashboard.putNumber("gyro180", s_drive.gyro180());
SmartDashboard.putNumber("gyro", s_drive.gyro().getValue());
//*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

s_drive.swerve(degrees+s_drive.gyro180(), 0, 0,degrees);
intake1.ChamberSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s_drive.drivee() > distance;
  }
}
