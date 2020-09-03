package info.sanaebadi.data.repository.dataSource.base;

import io.reactivex.Completable;
import okhttp3.internal.cache.CacheStrategy;

public interface BaseDataSourceFactory<T> {
    T create(CacheStrategy cacheStrategy, String... params);

    Completable deleteCache();
}
