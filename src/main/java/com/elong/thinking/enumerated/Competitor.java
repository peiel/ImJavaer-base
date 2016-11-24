package com.elong.thinking.enumerated;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public interface Competitor<T extends Competitor<T>> {
    Octcome compete(T competitor);
}
