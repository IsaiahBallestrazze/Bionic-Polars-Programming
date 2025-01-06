// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake2;
import frc.robot.subsystems.NeoPixels;

public class Shoot extends Command {
  /** Creates a new Shoot. */
  private final Intake2 s_Intake2;
  private final NeoPixels s_NeoPixels;

  private double Flyspeed = .85;
  private double Inspeed = .75;
  private double Chamspeed = .75;// .75
  private double RPMmax;
  private double RPM;
  private double fraction;
  private double values;
  private double truevalue;
  private int i;

  public Shoot(Intake2 d_Intake2, NeoPixels dPixels) {
    // Use addRequirements() here to declare subsystem dependencies.
s_NeoPixels=dPixels;
    s_Intake2 = d_Intake2;
    addRequirements(s_Intake2,s_NeoPixels);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_NeoPixels.setRGBs();
    s_NeoPixels.setRGB(0, 255, 0, 0);
    s_NeoPixels.setRGB(1, 255, 0, 0);
    s_NeoPixels.setRGB(2, 255, 0, 0);
    s_NeoPixels.setRGB(3, 255, 0, 0);
    s_NeoPixels.setRGB(4, 255, 0, 0);
    s_NeoPixels.setRGB(5, 255, 0, 0);
    s_NeoPixels.setRGB(7, 255, 0, 0);
    s_NeoPixels.setRGB(8, 255, 0, 0);
    s_NeoPixels.setRGB(9, 255, 0, 0);
    s_NeoPixels.setRGB(10, 255, 0, 0);
    s_NeoPixels.setRGB(11, 255, 0, 0);
    s_NeoPixels.setRGB(12, 255, 0, 0);
    s_NeoPixels.setRGB(13, 255, 0, 0);
    s_NeoPixels.setRGB(13, 255, 0, 0);
    s_NeoPixels.setRGB(14, 255, 0, 0);
    s_NeoPixels.setRGB(15, 255, 0, 0);
    s_NeoPixels.setRGB(16, 255, 0, 0);
    s_NeoPixels.setRGB(17, 255, 0, 0);
    s_NeoPixels.setRGB(18, 255, 0, 0);
    s_NeoPixels.setRGB(19, 255, 0, 0);
    s_NeoPixels.setRGB(20, 255, 0, 0);
    s_NeoPixels.setRGB(21, 255, 0, 0);
    s_NeoPixels.setRGB(22, 255, 0, 0);
    s_NeoPixels.setRGB(23, 255, 0, 0);
    s_NeoPixels.setRGB(24, 255, 0, 0);
    s_NeoPixels.setRGB(25, 255, 0, 0);
    s_NeoPixels.setRGB(26, 255, 0, 0);
    s_NeoPixels.setRGB(27, 255, 0, 0);
    s_NeoPixels.setRGB(28, 255, 0, 0);
    s_NeoPixels.setRGB(29, 255, 0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    try {
      RPMmax = 3000;
      fraction = s_Intake2.FlyEncoder() / RPMmax; // example of this, RPM = 30 so 100/3000 = 0.34, 0.34*30 = 1 replas
                                                  // rpm with encoder
      values = fraction * 28;
      // truevalue = Math.floor(values); // truevalue is equal to the index of the
      // Neopixels.
      i = 0;
      if (values > 29)
        values = 29;
      while (i <= values) {
        s_NeoPixels.setRGB(i, 255, 255, 255);

        i++;

      }
    } catch (Exception e) {}


    s_Intake2.Fly(Flyspeed);
    if (s_Intake2.FlyEncoder() > 2800) {
      s_Intake2.ChamberSpeed(Chamspeed);
      s_Intake2.IntakeSpeed(Inspeed);
    }

    SmartDashboard.putNumber("flywheel", Flyspeed);

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
