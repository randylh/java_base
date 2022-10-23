import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCache<K, V> {
    private final Map<K, V> m = new HashMap<>();
    private final ReadWriteLock rwl =  new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    V get(K key) {
        V v = null;
        //读缓存
        r.lock();
        try {
            v = m.get(key);
        } finally{
            r.unlock();
        }
        //缓存中存在，返回
        if(v != null) {
            return v;
        }
        //缓存中不存在，查询数据库
        w.lock();
        try {
            //再次验证缓存中是否存在数据
            v = m.get(key);
            if(v == null){
                //查询数据库
                v = queryFromDB();
                m.put(key, v);
            }
        } finally{
            w.unlock();
        }
        return v;
    }

    V queryFromDB() {
        return null;
    }
}
