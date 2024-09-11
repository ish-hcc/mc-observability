package mcmp.mc.observability.mco11ymanager.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpiderMonitoringGetVMMonitoringDto {
    @ApiModelProperty(value = "Connection name of CSP")
    private String ConnectionName;
    @ApiModelProperty(value = "Enter the time to search from how many hours before the current time.")
    private String TimeBeforeHour;
    @ApiModelProperty(value = "Enter interval in minutes.")
    private String IntervalMinute;
}
