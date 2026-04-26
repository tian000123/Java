package org.example.demo.springbootdemo.common;

import lombok.Data;

import java.util.List;

/**
 * ============================================
 * 知识点：分页查询结果封装
 * ============================================
 * 
 * 【核心概念】
 * 在Web开发中，列表数据通常需要分页展示，以提升性能和用户体验。
 * 分页结果封装类用于统一返回分页相关的所有信息。
 * 
 * 【分页参数说明】
 * - pageNum: 当前页码（从1开始）
 * - pageSize: 每页显示条数
 * - total: 总记录数
 * - pages: 总页数
 * - list: 当前页数据列表
 * 
 * @param <T> 列表数据的类型
 */
@Data
public class PageResult<T> {

    /**
     * 当前页码
     * 从1开始计数
     */
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 当前页数据列表
     */
    private List<T> list;

    /**
     * 是否有下一页
     */
    private Boolean hasNextPage;

    /**
     * 是否有上一页
     */
    private Boolean hasPreviousPage;

    /**
     * 是否为第一页
     */
    private Boolean isFirstPage;

    /**
     * 是否为最后一页
     */
    private Boolean isLastPage;

    /**
     * 私有构造方法
     */
    private PageResult() {}

    /**
     * ============================================
     * 创建分页结果
     * ============================================
     * 
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @param total 总记录数
     * @param list 当前页数据
     */
    public static <T> PageResult<T> of(Integer pageNum, Integer pageSize, Long total, List<T> list) {
        PageResult<T> result = new PageResult<>();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotal(total);
        result.setList(list);

        // 计算总页数
        result.setPages((int) Math.ceil((double) total / pageSize));

        // 计算分页状态
        result.setIsFirstPage(pageNum == 1);
        result.setIsLastPage(pageNum >= result.getPages());
        result.setHasNextPage(pageNum < result.getPages());
        result.setHasPreviousPage(pageNum > 1);

        return result;
    }

    /**
     * 创建空分页结果
     */
    public static <T> PageResult<T> empty(Integer pageNum, Integer pageSize) {
        return of(pageNum, pageSize, 0L, List.of());
    }
}
