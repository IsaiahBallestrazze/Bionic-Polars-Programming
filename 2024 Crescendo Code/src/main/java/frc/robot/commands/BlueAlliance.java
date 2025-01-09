// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.NeoPixels;
import edu.wpi.first.wpilibj2.command.Command;

public class BlueAlliance extends Command {
  private final NeoPixels s_NeoPixels;
  public BlueAlliance(NeoPixels d_NeoPixels) {
    s_NeoPixels = d_NeoPixels;
    addRequirements(s_NeoPixels);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_NeoPixels.setRGBs();
    s_NeoPixels.setRGB(0, 0, 0, 255);
    s_NeoPixels.setRGB(1, 0, 0, 255);
    s_NeoPixels.setRGB(2, 0, 0, 255);
    s_NeoPixels.setRGB(3, 0, 0, 255);
    s_NeoPixels.setRGB(4, 0, 0, 255);
    s_NeoPixels.setRGB(5, 0, 0, 255);
    s_NeoPixels.setRGB(6, 0, 0, 255);
    s_NeoPixels.setRGB(7, 0, 0, 255);
    s_NeoPixels.setRGB(8, 0, 0, 255);
    s_NeoPixels.setRGB(9, 0, 0, 255);
    s_NeoPixels.setRGB(10, 0, 0, 255);
    s_NeoPixels.setRGB(11, 0, 0, 255);
    s_NeoPixels.setRGB(12, 0, 0, 255);
    s_NeoPixels.setRGB(13, 0, 0, 255);
    s_NeoPixels.setRGB(14, 0, 0, 255);
    s_NeoPixels.setRGB(15, 0, 0, 255);
    s_NeoPixels.setRGB(16, 0, 0, 255);
    s_NeoPixels.setRGB(17, 0, 0, 255);
    s_NeoPixels.setRGB(18, 0, 0, 255);
    s_NeoPixels.setRGB(19, 0, 0, 255);
    s_NeoPixels.setRGB(20, 0, 0, 255);
    s_NeoPixels.setRGB(21, 0, 0, 255);
    s_NeoPixels.setRGB(22, 0, 0, 255);
    s_NeoPixels.setRGB(23, 0, 0, 255);
    s_NeoPixels.setRGB(24, 0, 0, 255);
    s_NeoPixels.setRGB(25, 0, 0, 255);
    s_NeoPixels.setRGB(26, 0, 0, 255);
    s_NeoPixels.setRGB(27, 0, 0, 255);
    s_NeoPixels.setRGB(28, 0, 0, 255);
    s_NeoPixels.setRGB(29, 0, 0, 255);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
