// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climer;

public class ClimerMove extends Command {
  /** Creates a new ClimerMove. */
private final Climer m_climer;
private final double m_varabol;

  public ClimerMove(Climer climer, double varabol) {
    m_climer = climer;
    m_varabol = varabol;
    addRequirements(m_climer);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climer.Climermotor(m_varabol);
    SmartDashboard.putNumber("climer", m_climer.ENL());
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
