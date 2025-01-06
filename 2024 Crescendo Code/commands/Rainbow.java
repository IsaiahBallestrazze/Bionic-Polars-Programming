// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.NeoPixels;
import edu.wpi.first.wpilibj2.command.Command;

public class Rainbow extends Command {
  private final NeoPixels s_NeoPixels;
  public Rainbow(NeoPixels d_NeoPixels) {
    s_NeoPixels = d_NeoPixels;
    addRequirements(s_NeoPixels);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_NeoPixels.setRGBs();
    
    s_NeoPixels.setRGB(0, 255,0,255);
    s_NeoPixels.setRGB(1, 255,0,255);
    s_NeoPixels.setRGB(2, 207, 159, 255);
    s_NeoPixels.setRGB(3, 207, 159, 255);
    s_NeoPixels.setRGB(4, 75, 0, 130);
    s_NeoPixels.setRGB(4, 75, 0, 130);
    s_NeoPixels.setRGB(6, 0,0,255);
    s_NeoPixels.setRGB(7, 0,0,255);
    s_NeoPixels.setRGB(8, 0, 0, 150);
    s_NeoPixels.setRGB(9, 0, 0, 150);
    s_NeoPixels.setRGB(10, 13, 152, 186);
    s_NeoPixels.setRGB(11, 13, 152, 186);
    s_NeoPixels.setRGB(12, 0,255,0);
    s_NeoPixels.setRGB(13, 0,255,0);
    s_NeoPixels.setRGB(14, 154, 205, 50);
    s_NeoPixels.setRGB(15, 154, 205, 50);
    s_NeoPixels.setRGB(16, 255, 255, 0);
    s_NeoPixels.setRGB(17, 255, 255, 0);
    s_NeoPixels.setRGB(18, 255,240,10);
    s_NeoPixels.setRGB(19, 255,240,10);
    s_NeoPixels.setRGB(20, 255, 174, 66);
    s_NeoPixels.setRGB(21, 255, 174, 66);
    s_NeoPixels.setRGB(22, 255, 165, 0);
    s_NeoPixels.setRGB(23, 255, 165, 0);
    s_NeoPixels.setRGB(24, 250, 108, 7);
    s_NeoPixels.setRGB(25, 250, 108, 7);
    s_NeoPixels.setRGB(26, 200,0,0);
    s_NeoPixels.setRGB(27, 200,0,0);
    s_NeoPixels.setRGB(28, 255, 0, 0);
    s_NeoPixels.setRGB(29, 255, 0, 0);
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
