// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.vison;

public class camreturn extends Command {
  /** Creates a new camreturn. */
private final vison s_vison;

  public camreturn(vison d_vison) {
s_vison=d_vison;
addRequirements(s_vison);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    SmartDashboard.putNumber("X",s_vison.camX());
    SmartDashboard.putNumber("Y",s_vison.camY());
    SmartDashboard.putNumber("yaw",s_vison.camyaw());
    SmartDashboard.putNumber("id", s_vison.id());

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
