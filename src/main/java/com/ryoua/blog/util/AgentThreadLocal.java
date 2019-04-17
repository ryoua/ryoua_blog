package com.ryoua.blog.util;

import com.ryoua.blog.domain.User;

/**
 * @Author ryoua Created on 2019-04-15
 */
public class AgentThreadLocal {
    private AgentThreadLocal() {}

    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();

    public static void set(User user) {
        LOCAL.set(user);
    }

    public static User get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}
