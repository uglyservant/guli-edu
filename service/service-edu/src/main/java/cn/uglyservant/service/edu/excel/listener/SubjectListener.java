package cn.uglyservant.service.edu.excel.listener;

import cn.uglyservant.service.edu.entity.Subject;
import cn.uglyservant.service.edu.excel.entity.SubjectHead;
import cn.uglyservant.service.edu.mapper.SubjectMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author uglys
 * @since 2:16 2020/7/18
 * TODO
 */
@Slf4j
@Component
public class SubjectListener extends AnalysisEventListener<SubjectHead> {

    private static final String ROOT_ID = "###################";

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public void invoke(SubjectHead subjectHead, AnalysisContext analysisContext) {
        log.info("课程信息，{}", subjectHead);

        // 一级分类
        Subject subject = subjectMapper.selectOne(
                new QueryWrapper<Subject>()
                        .eq("title", subjectHead.getFirstLevel())
                        .eq("parent_id", ROOT_ID)
        );
        if (subject == null) {
            subject = new Subject();
            subject.setTitle(subjectHead.getFirstLevel());
            subject.setParentId(ROOT_ID);
            subject.setSort(1);
            subjectMapper.insert(subject);
        }

        // 二级分类
        String parentId = subject.getId();
        subject = subjectMapper.selectOne(
                new QueryWrapper<Subject>()
                        .eq("title", subjectHead.getSecondaryLevel())
                        .eq("parent_id", parentId)
        );
        if (subject == null) {
            subject = new Subject();
            subject.setTitle(subjectHead.getSecondaryLevel());
            subject.setParentId(parentId);
            subject.setSort(1);
            subjectMapper.insert(subject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取完毕");
    }
}
