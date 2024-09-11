package mcmp.mc.observability.mco11ymanager.client;

import mcmp.mc.observability.mco11ymanager.config.SpiderFeignConfig;
import mcmp.mc.observability.mco11ymanager.model.SpiderMonitoring;
import mcmp.mc.observability.mco11ymanager.model.dto.SpiderMonitoringGetVMMonitoringDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cb-spider", url = "${feign.cb-spider.url:}", configuration = SpiderFeignConfig.class)
public interface SpiderClient {
    @GetMapping(value = "/spider/monitoring/vm/{vmName}/{metricType}", produces = "application/json")
    SpiderMonitoring.MetricData getVMMonitoring(@PathVariable String vmName, @PathVariable String metricType, @RequestBody SpiderMonitoringGetVMMonitoringDto spiderMonitoringGetVMMonitoringDto);
}
