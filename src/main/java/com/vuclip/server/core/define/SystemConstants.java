package com.vuclip.server.core.define;

import com.vuclip.server.core.exception.LifecycleException;
import com.vuclip.server.core.utils.ConfigUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-2-17
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class SystemConstants {
//    public static CacheProvider.CacheType DefaultCacheType = CacheProvider.CacheType.LRUMap;
    public static Boolean EXIT_ON_INIT_FAILURE = true;
//    public static String DBConfigCacheKey = DatabaseConfig.class.getName();
//    public static String DataSourceCacheKey = DataSource.class.getName();
//    public static String ServiceConfigCacheKey = ServiceConfig.class.getName();
//    public static String versionCacheKey = VersionConfig.class.getName();
    public static Map<String, String> renderingEngineMap = new HashMap();
    //public static ConcurrentHashMap<String,DatabaseConfig> configCurrentHashMap = new ConcurrentHashMap<String,DatabaseConfig>();


    public static Boolean writeMemcached;//=true; //如果是true,则更新memcache
    public static Boolean isInService;//= true; //如果是true，则从数据库加载redis配置信息，否则使用测试信息
    public static Boolean DebugMode;//=false;  //本地模式
    public static Boolean isApi;//=false;//本地模式(API)，如果是本地模式，则从内存中取数据 ,屏蔽日志输出
    public static Boolean isNoLogs;//=false;
    public static Boolean isHttpService;//=false;
    public static String RMI = "rmi";
    public static String HTTP = "http";
    public static Integer restHttpPort = 8080;
    public static String redisUrl;
    public static Integer redisPort;
    public static String redisPassword;

    static {
        renderingEngineMap.put("Gecko", "Gecko/");
        renderingEngineMap.put("WebKit", "AppleWebKit/");
        renderingEngineMap.put("Presto", "Opera/");
        renderingEngineMap.put("Trident", "Trident/");
        renderingEngineMap.put("Blink", "Chrome/");
        try {
            /*if(StringUtils.equalsIgnoreCase(ConfigUtil.initVersionConfig().getBuildProfile(),"api")){
                isApi=true;
                //DataFactory.loadMemoryCache();//API数据初始化到内存
            }*/
            writeMemcached = ConfigUtil.initSystemConfig().getWriteMemcached();
            isInService = ConfigUtil.initSystemConfig().getIsInService();
            DebugMode = ConfigUtil.initSystemConfig().getDebugMode();
            isApi = ConfigUtil.initSystemConfig().getIsApi();
            isNoLogs = ConfigUtil.initSystemConfig().getIsNoLogs();
            isHttpService = ConfigUtil.initSystemConfig().getIsHttpService();
            restHttpPort = ConfigUtil.initSystemConfig().getRestHttpPort();
//            redisUrl = ConfigUtil.initRedisConfig().getRedisUrl();
//            redisPort = ConfigUtil.initRedisConfig().getRedisPort();
//            redisPassword = ConfigUtil.initRedisConfig().getRedisPassword();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //RedisCacheProvider redisCacheProvider= new RedisCacheProvider();
        System.out.print("r:" + restHttpPort + "--re:" + redisUrl + "--red:" + redisPort
                + "--isP:" + redisPassword);
    }


}
