// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.NeoPixels;
import java.util.Random;
 
public class Random_Light extends Command {
  private  int r;
  private  int i;
  private  int g;
  private  int b;
  private Random rand = new Random();
  private int index = 30;
 private final NeoPixels s_NeoPixels;
  public Random_Light(NeoPixels d_NeoPixels) {
    s_NeoPixels = d_NeoPixels;
    addRequirements(s_NeoPixels);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_NeoPixels.setRGBs();

    for(int j=0; j<index; j++){
      r = rand.nextInt(255);
      g = rand.nextInt(255);
      b = rand.nextInt(255);
      s_NeoPixels.setRGB(j, r, g, b);
  }}

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
