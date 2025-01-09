// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class GyroCommand extends Command {
  /** Creates a new GyroCommadn. */
 private final Drivetrain s_Drivetrain;

 private Double Angle;
 private double calibrationConstant =  0.001; // can be changed based on romi
  public GyroCommand(Drivetrain d_Drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_Drivetrain = d_Drivetrain;
    addRequirements(s_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_Drivetrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Angle =  s_Drivetrain.getGyroAngleZ();
    calibrationConstant = calibrationConstant + 0.0638;
    Angle = Angle - calibrationConstant;
    if(Angle > 360) Angle = Angle - 360;
    if(Angle < -360) Angle = Angle + 360;
    System.out.println(Angle);

    if(Angle >= 0) s_Drivetrain.arcadeDrive(.5, Angle / 50);
        if(Angle <= 0) s_Drivetrain.arcadeDrive(.5, Angle / 50);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
