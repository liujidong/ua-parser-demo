package com.vuclip.server.core.utils;

import com.vuclip.server.core.entity.SystemConfig;
import com.vuclip.server.core.exception.LifecycleException;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigUtil {
    private final static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    //private final static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
    public static Boolean inited = false;

    /**
     * 初始化数据库所需参数配置
     */
//    @SuppressWarnings("unchecked")
//	public static DatabaseConfig initDBConfig() throws LifecycleException {
//        //Properties props = new Properties();
//        DatabaseConfig databaseConfig = new DatabaseConfig();
//        try {
//            databaseConfig = databaseConfig.getInstance("druid");
//
//            if (CacheManager.CacheInited) {
//                CacheManager.putInCache(SystemConstants.DBConfigCacheKey, databaseConfig);
//            }
//        } catch (Exception e) {
//            throw new LifecycleException(e);
//        }
//        return databaseConfig;
//    }
    
    @SuppressWarnings("unchecked")
//	public  static VersionConfig  initVersionConfig() throws LifecycleException {
//    	  Properties props = new Properties();
//    	  VersionConfig versionConfig = null;
//          try {
//              InputStream is = ClassLoader.getSystemResourceAsStream("build.properties");
//              if(is==null){
//                  Enumeration urls = Thread.currentThread().getContextClassLoader().getResources("build.properties");
//                  while (urls.hasMoreElements()) {
//                      URL url = (URL) urls.nextElement();
//                     try {
//                          URLConnection con = url.openConnection();
//                          is = con.getInputStream();
//                          props.load(is);
//                      }
//                      finally {
//                          if (is != null) {
//                              is.close();
//                          }
//                      }
//                  }
//              }else{
//              	  props.load(is);
//              }
//              versionConfig = new VersionConfig();
//              String buildVersion = props.getProperty("buildVersion");
//              if (!StringUtils.isEmpty(buildVersion)) {
//                 versionConfig.setBuildVersion(buildVersion);
//              }
//              String buildTimestamp = props.getProperty("buildTimestamp");
//              if (!StringUtils.isEmpty(buildTimestamp)) {
//                 versionConfig.setBuildTimestamp(buildTimestamp);
//              }
//              String buildProfile = props.getProperty("buildProfile");
//              if (!StringUtils.isEmpty(buildProfile)) {
//                 versionConfig.setBuildProfile(buildProfile);
//              }
//
//          }catch (IOException e) {
//              throw new LifecycleException(e);
//          }
//          return versionConfig;
//    }

    /**
     * 初始化数据库所需参数配置
     */
//    public static ServiceConfig initServiceConfig() throws LifecycleException {
//        initDBConfig();
//        Properties props = new Properties();
//        ServiceConfig serviceConfig = null;
//        try {
//            InputStream is = classLoader.getSystemResourceAsStream("service.properties");
//            props.load(is);
//            serviceConfig = new ServiceConfig();
//
//            Set<String> serviceNameSet = props.stringPropertyNames();
//            for (String serviceName : serviceNameSet) {
//                String className = props.getProperty(serviceName);
//                Class<?> clazz = classLoader.loadClass(className);
//                serviceConfig.addService(serviceName, clazz);
//            }
//            if (CacheManager.CacheInited)
//                CacheManager.putInCache(SystemConstants.ServiceConfigCacheKey, serviceConfig);
//        } catch (IOException e) {
//            throw new LifecycleException(e);
//        } catch (ClassNotFoundException e) {
//            throw new LifecycleException(e);
//        }
//        inited = true;
//        return serviceConfig;
//    }

    /**
     * 系统配置信息
     * @return
     * @throws LifecycleException
     */
    public  static SystemConfig  initSystemConfig() throws LifecycleException {
        Properties props = new Properties();
        SystemConfig systemConfig = null;
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("system_constants.properties");
            if(is==null){
                Enumeration urls = Thread.currentThread().getContextClassLoader().getResources("system_constants.properties");
                while (urls.hasMoreElements()) {
                    URL url = (URL) urls.nextElement();
                    try {
                        URLConnection con = url.openConnection();
                        is = con.getInputStream();
                        props.load(is);
                    }
                    finally {
                        if (is != null) {
                            is.close();
                        }
                    }
                }
            }else{
                props.load(is);
            }
            systemConfig = new SystemConfig();
            String writeMemcached = props.getProperty("writeMemcached");
            if (StringUtils.isNotBlank(writeMemcached)) {
                systemConfig.setWriteMemcached(Boolean.parseBoolean(writeMemcached));
            }else{
                systemConfig.setWriteMemcached(false);
            }
            String isInService = props.getProperty("isInService");
            if (StringUtils.isNotBlank(isInService)) {
                systemConfig.setIsInService(Boolean.parseBoolean(isInService));
            }else{
                systemConfig.setIsHttpService(false);
            }
            String debugMode = props.getProperty("DebugMode");
            if (!StringUtils.isEmpty(debugMode)) {
                systemConfig.setDebugMode(Boolean.parseBoolean(debugMode));
            }else{
                systemConfig.setDebugMode(false);
            }
            String isApi = props.getProperty("isApi");
            if (!StringUtils.isEmpty(isApi.toString())) {
                systemConfig.setIsApi(Boolean.parseBoolean(isApi));
            }else{
                systemConfig.setIsApi(false);
            }
            String isNoLogs = props.getProperty("isNoLogs");
            if (!StringUtils.isEmpty(isNoLogs)) {
                systemConfig.setIsNoLogs(Boolean.parseBoolean(isNoLogs));
            }else{
                systemConfig.setIsNoLogs(false);
            }
            String isHttpService = props.getProperty("isHttpService");
            if (!StringUtils.isEmpty(isHttpService)) {
                systemConfig.setIsHttpService(Boolean.parseBoolean(isHttpService));
            }else{
                systemConfig.setIsHttpService(false);
            }
            String restHttpPort = props.getProperty("rest.http.port");
            if(StringUtils.isNotBlank(restHttpPort)){
                systemConfig.setRestHttpPort(Integer.parseInt(restHttpPort));
            }
        }catch (IOException e) {
            throw new LifecycleException(e);
        }
        return systemConfig;
    }

    /**
     * redis配置信息
     * @return
     * @throws LifecycleException
     */
//    public  static RedisConfig initRedisConfig() throws LifecycleException {
//        Properties props = new Properties();
//        RedisConfig redisConfig = null;
//        try {
//            InputStream is = ClassLoader.getSystemResourceAsStream("redis_config.properties");
//            if(is==null){
//                Enumeration urls = Thread.currentThread().getContextClassLoader().getResources("redis_config.properties");
//                while (urls.hasMoreElements()) {
//                    URL url = (URL) urls.nextElement();
//                    try {
//                        URLConnection con = url.openConnection();
//                        is = con.getInputStream();
//                        props.load(is);
//                    }
//                    finally {
//                        if (is != null) {
//                            is.close();
//                        }
//                    }
//                }
//            }else{
//                props.load(is);
//            }
//            redisConfig = new RedisConfig();
//            String redisUrl = props.getProperty("redisUrl");
//            if (StringUtils.isNotBlank(redisUrl)) {
//                redisConfig.setRedisUrl(redisUrl);
//            }
//            String redisPort = props.getProperty("redisPort");
//            if (StringUtils.isNotBlank(redisPort)) {
//                redisConfig.setRedisPort(Integer.parseInt(redisPort));
//            }
//            String redisPassword = props.getProperty("redisPassword");
//            if (StringUtils.isNotBlank(redisPassword)) {
//                redisConfig.setRedisPassword(redisPassword);
//            }
//        }catch (IOException e) {
//            throw new LifecycleException(e);
//        }
//        return redisConfig;
//    }


}