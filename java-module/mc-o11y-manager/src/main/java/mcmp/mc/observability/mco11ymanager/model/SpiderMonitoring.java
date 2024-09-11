package mcmp.mc.observability.mco11ymanager.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpiderMonitoring {
    @Getter
    @Setter
    public static class TimestampValue {
        private String timestamp;
        private String value;
    }
    @Getter
    @Setter
    public static class MetricData {
        private String metricName;
        private String metricUnit;
        private TimestampValue[] timestampValues;
    }
}
