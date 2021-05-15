package com.tsinghua.course.Biz.Controller.Params;

/**
 * @描述 通用出参，所有的出参都需要继承自此类
 **/
public class CommonOutParams extends CommonParams {
    /** 业务执行成功与否 */
    protected boolean success;
    /** 业务执行的具体时间，系统会在返回前自动填充 */
    protected Long execute_time;

    public CommonOutParams() {
        this.success = true;
    }

    public CommonOutParams(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getExecute_time() { return execute_time; }

    public void setExecute_time(Long execute_time) { this.execute_time = execute_time; }

    @Override
    protected void beforeTransfer() {
        if (execute_time == null)
            execute_time = System.currentTimeMillis();
    }
}
