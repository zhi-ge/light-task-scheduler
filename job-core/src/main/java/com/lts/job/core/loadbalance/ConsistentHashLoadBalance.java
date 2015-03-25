package com.lts.job.core.loadbalance;

import com.lts.job.core.support.ConsistentHashSelector;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 一致性hash算法
 * Robert HG (254963746@qq.com) on 3/25/15.
 */
public class ConsistentHashLoadBalance extends AbstractLoadBalance {

    @Override
    protected <S> S doSelect(List<S> shards) {
        ConsistentHashSelector<S> selector = new ConsistentHashSelector<S>(shards);
        return selector.selectForKey("HASH-".concat(String.valueOf(ThreadLocalRandom.current().nextInt())));
    }
}
