package ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class RateLimitManager {
    // Static singleton class which is thread safe from multiple instantiation race conditions in traiditonal sigletons
    public static final RateLimitManager _instance = new RateLimitManager();
    // Container for keeping track of all provisioned rate limits.
    private ConcurrentHashMap<String, RateLimitExecutor> rateLimitMap = new ConcurrentHashMap<String, RateLimitExecutor>();
    // Thread pool initialization
    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // To provision a new Rate Limit Policy and executor. Callback interface to receive notifications
    public void provisionRateLimit(RateLimitExecutor rateLimitExecutor, String client_ID, RateLimitListener listener) {
        rateLimitExecutor.setListener(listener);
        rateLimitMap.put(client_ID, rateLimitExecutor);
    }

    // To remove a rate limit policy
    public void deProvisionRateLimit(String instance_id) {
        try {
            rateLimitMap.remove(instance_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // API Call to peg traffic and evaluate the rate limit provisioned
    public void pegTraffic(String instance_id) {
        rateLimitMap.get(instance_id).evalute();
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
}