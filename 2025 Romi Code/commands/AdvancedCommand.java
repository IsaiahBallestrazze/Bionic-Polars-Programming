// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class AdvancedCommand extends Command {
  /** Creates a new AdvancedCommand. */

  private final Drivetrain s_Drivetrain;
  private double speed;
  private double distance;
  public AdvancedCommand(Drivetrain d_Drivetrain, double d_speed, double d_distance ) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_Drivetrain = d_Drivetrain;
    speed = d_speed;
    distance = d_distance;

    addRequirements(s_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_Drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Drivetrain.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_Drivetrain.arcadeDrive(speed, distance);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(s_Drivetrain.getAverageDistanceInch()) > distance;
  }
}
