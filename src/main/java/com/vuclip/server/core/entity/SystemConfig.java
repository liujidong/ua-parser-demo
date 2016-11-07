package com.vuclip.server.core.entity;

import java.io.Serializable;

/**
 * 记录系统信息
 * @author v
 *
 */
public class SystemConfig implements Serializable {
	private Boolean writeMemcached;
	private Boolean isInService;
	private Boolean DebugMode;
    private Boolean isApi;
    private Boolean isNoLogs;
    private Boolean isHttpService;
    private Integer restHttpPort;


    public Boolean getWriteMemcached() {
        return writeMemcached;
    }

    public void setWriteMemcached(Boolean writeMemcached) {
        this.writeMemcached = writeMemcached;
    }

    public Boolean getIsInService() {
        return isInService;
    }

    public void setIsInService(Boolean isInService) {
        this.isInService = isInService;
    }

    public Boolean getDebugMode() {
        return DebugMode;
    }

    public void setDebugMode(Boolean debugMode) {
        DebugMode = debugMode;
    }

    public Boolean getIsApi() {
        return isApi;
    }

    public void setIsApi(Boolean isApi) {
        this.isApi = isApi;
    }

    public Boolean getIsNoLogs() {
        return isNoLogs;
    }

    public void setIsNoLogs(Boolean isNoLogs) {
        this.isNoLogs = isNoLogs;
    }

    public Boolean getIsHttpService() {
        return isHttpService;
    }

    public void setIsHttpService(Boolean isHttpService) {
        this.isHttpService = isHttpService;
    }

    public Integer getRestHttpPort() {
        return restHttpPort;
    }

    public void setRestHttpPort(Integer restHttpPort) {
        this.restHttpPort = restHttpPort;
    }
}
