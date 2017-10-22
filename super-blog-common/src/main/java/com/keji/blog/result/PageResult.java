package com.keji.blog.result;

import lombok.Data;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/22
 * @modified: By:
 */
@Data
public class PageResult<T> extends BaseResult<T> {

    /**
     * 当前页
     */
    protected Integer pageIndex;

    /**
     * 每页显示个数
     */
    protected Integer pageSize;

    /**
     * 总个数
     */
    protected Long count;

    /**
     * 排序方式
     */
    protected String orderBy;

    public PageResult(){}

    public PageResult(T data, Long count) {
        super();
        super.data = data;
        this.count = count;
    }

    public PageResult<T> makeSuccess(T data, Long count) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(true);
        pageResult.setCount(count);
        pageResult.setData(data);
        return pageResult;
    }

    public PageResult makeFail() {
        PageResult<Object> pageResult = new PageResult<>();
        pageResult.setSuccess(false);
        return pageResult;
    }

}
