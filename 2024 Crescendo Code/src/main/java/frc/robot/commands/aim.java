// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.vison;

public class aim extends Command {
  /** Creates a new aim. */

  private final vison s_vison;
  private final Arm s_arm;
  private double angle;

  public aim(vison d_Vison, Arm d_Arm) {

    s_arm = d_Arm;
    s_vison = d_Vison;

    addRequirements(d_Arm, d_Vison);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (s_vison.id() == 0 || s_vison.id() == 7 || s_vison.id() == 4) {
      angle = 5 - ((Math.toDegrees(Math.tanh(2 / (s_vison.camX() * 1))) * 5) / 50) + 0.05;

      if (angle > 4) {
        // angle=4;
      }
    }
    s_arm.ArmAngle(angle);
    SmartDashboard.putNumber("angal", angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
