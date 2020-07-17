package cn.uglyservant.service.edu.excel.listener;

import cn.uglyservant.service.edu.excel.entity.Subject;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author uglys
 * @since 2:16 2020/7/18
 * TODO
 */
@Slf4j
public class SubjectListener extends AnalysisEventListener<Subject> {
    @Override
    public void invoke(Subject subject, AnalysisContext analysisContext) {
        log.info("课程信息，{}", subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取完毕");
    }
}
