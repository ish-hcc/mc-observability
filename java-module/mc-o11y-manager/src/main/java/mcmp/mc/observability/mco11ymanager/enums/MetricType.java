package mcmp.mc.observability.mco11ymanager.enums;

public enum MetricType {
    CPUUsage,
    MemoryUsage,
    DiskRead,
    DiskWrite,
    DiskReadOps,
    DiskWriteOps,
    NetworkIn,
    NetworkOut,
    Unknown,
    ;

    public static MetricType parse(String name) {
        for( MetricType t : MetricType.values() ) {
            if( t.name().equalsIgnoreCase(name) ) return t;
        }
        return null;
    }

    public static MetricType getMetricType(String input) {
        return switch (input) {
            case "cpu_usage" -> CPUUsage;
            case "memory_usage" -> MemoryUsage;
            case "disk_read" -> DiskRead;
            case "disk_write" -> DiskWrite;
            case "disk_read_ops" -> DiskReadOps;
            case "disk_write_ops" -> DiskWriteOps;
            case "network_in" -> NetworkIn;
            case "network_out" -> NetworkOut;
            default -> Unknown;
        };
    }
}