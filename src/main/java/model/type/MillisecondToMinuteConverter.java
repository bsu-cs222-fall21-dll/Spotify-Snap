package model.type;

import java.text.DecimalFormat;

public class MillisecondToMinuteConverter {

    public double convertToMin(String duration_ms) {
        double duration = Integer.parseInt(duration_ms) / 60000.0;
        return Math.round(duration*10.0)/10.0;
    }
}
