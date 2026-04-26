package org.example.demo.springbootdemo.repository;

import org.example.demo.springbootdemo.util.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * ============================================
 * 知识点：数据访问层（Repository/DAO层）
 * ============================================
 * 
 * 【核心概念】
 * Repository层（也称为DAO层 - Data Access Object）负责与数据源交互，
 * 执行数据的增删改查操作。它是三层架构中的最底层。
 * 
 * 【三层架构说明】
 * 1. Controller层（控制层）：接收请求，调用Service，返回响应
 * 2. Service层（业务层）：处理业务逻辑，调用Repository
 * 3. Repository层（数据层）：直接操作数据库/数据源
 * 
 * 【@Repository注解】
 * - 标识这是一个数据访问组件
 * - 会被Spring扫描并纳入容器管理
 * - 可以将数据访问异常转换为Spring的统一异常体系
 * 
 * 【本类说明】
 * 为便于教学演示，本类使用ConcurrentHashMap模拟数据库存储。
 * 实际项目中，这里应该使用：
 * - MyBatis的Mapper接口
 * - JPA的Repository接口
 * - 或直接使用JdbcTemplate
 */
@Repository
public class UserRepository {

    /**
     * 使用ConcurrentHashMap模拟数据库存储
     * key: 用户ID
     * value: 用户对象
     * 
     * 选择ConcurrentHashMap的原因：
     * 1. 线程安全，支持并发访问
     * 2. 性能较好
     * 3. 适合教学演示
     */
    private final Map<Long, User> userStore = new ConcurrentHashMap<>();

    /**
     * 自增ID生成器
     * AtomicLong保证线程安全的自增操作
     */
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * ============================================
     * 构造方法 - 初始化一些测试数据
     * ============================================
     */
    public UserRepository() {
        // 初始化3个测试用户
        initTestData();
    }

    /**
     * 初始化测试数据
     */
    private void initTestData() {
        User user1 = new User();
        user1.setId(idGenerator.getAndIncrement());
        user1.setUsername("zhangsan");
        user1.setPassword("123456");
        user1.setEmail("zhangsan@example.com");
        user1.setPhone("13800138001");
        user1.setAge(25);
        user1.setGender(1);
        user1.setStatus(1);
        user1.setCreateTime(LocalDateTime.now());
        user1.setUpdateTime(LocalDateTime.now());
        userStore.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(idGenerator.getAndIncrement());
        user2.setUsername("lisi");
        user2.setPassword("123456");
        user2.setEmail("lisi@example.com");
        user2.setPhone("13800138002");
        user2.setAge(28);
        user2.setGender(1);
        user2.setStatus(1);
        user2.setCreateTime(LocalDateTime.now());
        user2.setUpdateTime(LocalDateTime.now());
        userStore.put(user2.getId(), user2);

        User user3 = new User();
        user3.setId(idGenerator.getAndIncrement());
        user3.setUsername("wangwu");
        user3.setPassword("123456");
        user3.setEmail("wangwu@example.com");
        user3.setPhone("13800138003");
        user3.setAge(22);
        user3.setGender(0);
        user3.setStatus(1);
        user3.setCreateTime(LocalDateTime.now());
        user3.setUpdateTime(LocalDateTime.now());
        userStore.put(user3.getId(), user3);
    }

    /**
     * ============================================
     * 新增用户
     * ============================================
     * 
     * @param user 用户对象
     * @return 保存后的用户（包含生成的ID）
     */
    public User save(User user) {
        // 生成新ID
        user.setId(idGenerator.getAndIncrement());
        // 设置创建和更新时间
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        // 默认状态为启用
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        // 保存到存储
        userStore.put(user.getId(), user);
        return user;
    }

    /**
     * ============================================
     * 根据ID查询用户
     * ============================================
     * 
     * @param id 用户ID
     * @return 用户对象，不存在则返回null
     */
    public User findById(Long id) {
        return userStore.get(id);
    }

    /**
     * ============================================
     * 查询所有用户
     * ============================================
     * 
     * @return 用户列表
     */
    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    /**
     * ============================================
     * 根据用户名查询用户
     * ============================================
     * 
     * @param username 用户名
     * @return 用户对象，不存在则返回null
     */
    public User findByUsername(String username) {
        return userStore.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    /**
     * ============================================
     * 更新用户
     * ============================================
     * 
     * @param user 用户对象
     * @return 更新后的用户
     */
    public User update(User user) {
        if (user.getId() == null || !userStore.containsKey(user.getId())) {
            return null;
        }
        // 保留创建时间
        User existingUser = userStore.get(user.getId());
        user.setCreateTime(existingUser.getCreateTime());
        // 更新修改时间
        user.setUpdateTime(LocalDateTime.now());
        userStore.put(user.getId(), user);
        return user;
    }

    /**
     * ============================================
     * 根据ID删除用户
     * ============================================
     * 
     * @param id 用户ID
     * @return 是否删除成功
     */
    public boolean deleteById(Long id) {
        return userStore.remove(id) != null;
    }

    /**
     * ============================================
     * 分页查询用户
     * ============================================
     * 
     * @param pageNum 页码（从1开始）
     * @param pageSize 每页条数
     * @return 分页数据
     */
    public List<User> findByPage(int pageNum, int pageSize) {
        List<User> allUsers = new ArrayList<>(userStore.values());
        int fromIndex = (pageNum - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, allUsers.size());
        
        if (fromIndex >= allUsers.size()) {
            return new ArrayList<>();
        }
        return allUsers.subList(fromIndex, toIndex);
    }

    /**
     * ============================================
     * 获取用户总数
     * ============================================
     * 
     * @return 用户总数
     */
    public long count() {
        return userStore.size();
    }

    /**
     * ============================================
     * 根据条件搜索用户
     * ============================================
     * 
     * @param keyword 关键词（匹配用户名或邮箱）
     * @return 匹配的用户列表
     */
    public List<User> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll();
        }
        String lowerKeyword = keyword.toLowerCase();
        return userStore.values().stream()
                .filter(user -> 
                    user.getUsername().toLowerCase().contains(lowerKeyword) ||
                    user.getEmail().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }
}
