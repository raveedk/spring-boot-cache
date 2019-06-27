package com.ravee.springboot.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EhCacheEventLogger implements CacheEventListener<Object, Object> {
	private static final Logger logger = LoggerFactory.getLogger(EhCacheEventLogger.class);

	@Override
	public void onEvent(CacheEvent<?, ?> cacheEvent) {
		logger.info("custom Caching event {} {} {} {} ", cacheEvent.getType(), cacheEvent.getKey(),
				cacheEvent.getOldValue(), cacheEvent.getNewValue());

	}
}
