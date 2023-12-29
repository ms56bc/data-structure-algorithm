package org.atlassian;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ApiRateLimiter {
    record UserApi(Long userId, String apiName) {}
    record ApiStatus(long count, Instant firstAccessed) {}
    record ApiLimit(long requests, ChronoUnit unit) {}
    Map<UserApi, ApiLimit> apiCache;
    Map<UserApi, ApiStatus> apiCurrentStatus;

    public ApiRateLimiter(){
        apiCache = new HashMap<>();
        apiCurrentStatus = new HashMap<>();
        apiCache.put(new UserApi(1L, "api1"), new ApiLimit(10L, ChronoUnit.SECONDS));
        apiCache.put(new UserApi(1L, "api1"), new ApiLimit(10L, ChronoUnit.SECONDS));
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ApiRateLimiter");
        var apiRateLimiter = new ApiRateLimiter();
        IntStream.range(0, 20).forEach(i -> System.out.println(apiRateLimiter.isAllowed("api1", 1L)));
        Thread.sleep(1000);
        IntStream.range(0, 5).forEach(i -> System.out.println(apiRateLimiter.isAllowed("api1", 1L)));

    }

    private boolean isAllowed(String apiName, long userId) {
        var limit = getApiLimit(apiName, userId);
        if(limit == null) return true;
        var s = getCurrentCount(apiName, userId);
        if(s == null){
            apiCurrentStatus.put(new UserApi(userId, apiName), new ApiStatus(1, Instant.now()));
            return true;
        }
        if(s.firstAccessed.isBefore(Instant.now().minus(1, limit.unit()))){
            apiCurrentStatus.put(new UserApi(userId, apiName), new ApiStatus(1, Instant.now()));
            return true;
        } else {
            if(s.count < limit.requests()){
                apiCurrentStatus.put(new UserApi(userId, apiName), new ApiStatus(s.count + 1, s.firstAccessed));
                return true;
            }
        }
        return false;
    }

    private ApiLimit getApiLimit(String apiName, long userId) {
        return apiCache.get(new UserApi(userId, apiName));
    }
    private ApiStatus getCurrentCount(String apiName, long userId) {
        return apiCurrentStatus.get(new UserApi(userId, apiName));
    }
}
