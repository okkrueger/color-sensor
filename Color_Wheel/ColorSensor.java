package frc.robot.Color_Wheel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Map;


public class ColorSensor {
  
  public static boolean isBlue = false;
  public static boolean isRed = false;
  public static boolean isGreen = false;
  public static boolean isYellow = false;
  final Color detectedColor = Map.ColorWheel.sensor.getColor();
  private static double maxColorError = 0.1;

  private static boolean isColor(Calibrate.Color1 original, Calibrate.Color1 color){
    double RabsError = Math.abs(original.r - color.r);
    double GabsError = Math.abs(original.g - color.g);
    double BabsError = Math.abs(original.b - color.b);

    if(RabsError<maxColorError && GabsError<maxColorError && BabsError<maxColorError){
      return true;
    }else{
      return false;
    }
  }
  
  public static void getColor(){
    Color precolor = Map.ColorWheel.sensor.getColor();
    Calibrate.Color1 color = new Calibrate.Color1();
    color.r=precolor.red;
    color.g=precolor.green;
    color.b=precolor.blue;

    String current_color;

    if(isColor(color, Calibrate.Colors.Red)){
      isRed = true;
      current_color = "Red";

    }else if(isColor(color, Calibrate.Colors.Green)){
      isGreen = true;
      current_color = "Green";

    }else if(isColor(color, Calibrate.Colors.Blue)){
      isBlue = true;
      current_color = "Blue";

    }else if(isColor(color, Calibrate.Colors.Yellow)){
      isYellow = true;
      current_color = "Yellow";

    }else{
      isRed = false;
      isBlue = false;
      isGreen = false;
      isYellow = false;
      current_color = "No Color";

    }
    SmartDashboard.putString("Color Detected:", current_color);
  }
}


// private static boolean isColor(Calibrate.Color1 color, Calibrate.Color1 compare){

//   double Rabserror = Math.abs(compare.r-color.r);
//   double Gabserror = Math.abs(compare.g-color.g);
//   double Babserror = Math.abs(compare.b-color.b);

//   if(Rabserror<maxColorError && Gabserror<maxColorError && Babserror<maxColorError){
//     return true;
//   }else{
//     return false;
//   }