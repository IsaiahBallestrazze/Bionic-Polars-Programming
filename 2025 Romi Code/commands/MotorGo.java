// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class MotorGo extends Command {
  /** Creates a new RightMotorGo. */
  private double speed;
  private double turning;
  private final Drivetrain s_Drivetrain;
  public MotorGo(Drivetrain d_Drivetrain, double d_speed, double d_turning) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_Drivetrain = d_Drivetrain;
  speed = d_speed;
  turning = d_turning;
    addRequirements(s_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Drivetrain.arcadeDrive(speed,turning);
    if(turning == 1) System.out.println("LEFT");
    if(turning == -1) System.out.println("RIGHT");
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