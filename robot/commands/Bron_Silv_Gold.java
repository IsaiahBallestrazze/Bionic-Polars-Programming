// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.NeoPixels;
import edu.wpi.first.wpilibj2.command.Command;

public class Bron_Silv_Gold extends Command {
  private final NeoPixels s_NeoPixels;
  public Bron_Silv_Gold(NeoPixels d_NeoPixels) {
    s_NeoPixels = d_NeoPixels;
    addRequirements(s_NeoPixels);
  }

  // Bronze, Silver, and Gold, probably for show
  @Override
  public void initialize() {
    s_NeoPixels.setRGBs();
    s_NeoPixels.setRGB(0, 205, 127, 50);
    s_NeoPixels.setRGB(1, 205, 127, 50);
    s_NeoPixels.setRGB(2, 205, 127, 50);
    s_NeoPixels.setRGB(3, 205, 127, 50);
    s_NeoPixels.setRGB(4, 205, 127, 50);
    s_NeoPixels.setRGB(5, 205, 127, 50);
    s_NeoPixels.setRGB(6, 205, 127, 50);
    s_NeoPixels.setRGB(7, 205, 127, 50);
    s_NeoPixels.setRGB(8, 205, 127, 50);
    s_NeoPixels.setRGB(9, 205, 127, 50);
    s_NeoPixels.setRGB(10, 192, 192, 192);
    s_NeoPixels.setRGB(11, 192, 192, 192);
    s_NeoPixels.setRGB(12, 192, 192, 192);
    s_NeoPixels.setRGB(13, 192, 192, 192);
    s_NeoPixels.setRGB(14, 192, 192, 192);
    s_NeoPixels.setRGB(15, 192, 192, 192);
    s_NeoPixels.setRGB(16, 192, 192, 192);
    s_NeoPixels.setRGB(17, 192, 192, 192);
    s_NeoPixels.setRGB(18, 192, 192, 192);
    s_NeoPixels.setRGB(19, 192, 192, 192);
    s_NeoPixels.setRGB(20, 235, 186, 53);
    s_NeoPixels.setRGB(21, 235, 186, 53);
    s_NeoPixels.setRGB(22, 235, 186, 53);
    s_NeoPixels.setRGB(23, 235, 186, 53);
    s_NeoPixels.setRGB(24, 235, 255, 53);
    s_NeoPixels.setRGB(25, 235, 186, 53);
    s_NeoPixels.setRGB(26, 235, 186, 53);
    s_NeoPixels.setRGB(27, 235, 186, 53);
    s_NeoPixels.setRGB(28, 235, 186, 53);
    s_NeoPixels.setRGB(29, 235, 255, 53);
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
