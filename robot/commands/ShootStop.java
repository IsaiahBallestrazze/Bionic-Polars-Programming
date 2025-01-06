// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake2;

public class ShootStop extends Command {
  /** Creates a new Shoot. */
  private final Intake2 s_Intake2;

  public ShootStop(Intake2 d_Intake2) {
    // Use addRequirements() here to declare subsystem dependencies.


    s_Intake2 = d_Intake2;
    addRequirements(s_Intake2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    s_Intake2.Fly(0.0);
    s_Intake2.ChamberSpeed(0.0);
    s_Intake2.IntakeSpeed(0.0);

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
