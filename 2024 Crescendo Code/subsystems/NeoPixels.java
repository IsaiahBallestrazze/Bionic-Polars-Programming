// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NeoPixels extends SubsystemBase {
 private final AddressableLED NEOP = new AddressableLED(9);
 private final AddressableLEDBuffer NEOPS  = new AddressableLEDBuffer(30);

  public NeoPixels() {
  NEOP.setLength(NEOPS.getLength());
  NEOP.start();
  }
//hello!!!!
  public void setRGB(int index, int r, int g, int b){
   NEOPS.setRGB(index, r, g, b);
  }

  public void setRGBs(){
    NEOP.setData(NEOPS);
  }


  @Override
  public void periodic() {
    NEOP.setData(NEOPS);
  }
}
