// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class auto_arm extends Command {
  /** Creates a new Drive. */
  private final Arm s_Arm;

  private double angle;


  public auto_arm(Arm d_Arm,  double d_angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_Arm = d_Arm;
    angle = d_angle;
    addRequirements(s_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Arm.ArmAngle(angle);
    SmartDashboard.putNumber("Encoder",s_Arm.EncoderValue());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s_Arm.EncoderValue()>angle-.2&& s_Arm.EncoderValue()<angle+.2;
  }
}
