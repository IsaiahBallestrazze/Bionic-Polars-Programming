// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.vison;

public class auto_speek extends Command {

  private final drive s_drive;


  private double degrees;
  private double speed;
  private double turn2;

  /** Creates a new swervedrive. */
  public auto_speek(drive d_drive) {

    s_drive = d_drive;
  

    addRequirements(s_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_drive.off(s_drive.gyro180());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turn2 == 0;
  }
}
