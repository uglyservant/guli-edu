package cn.uglyservant.service.edu.service.impl;

import cn.uglyservant.common.global.exception.GuliException;
import cn.uglyservant.service.edu.entity.Subject;
import cn.uglyservant.service.edu.excel.entity.SubjectHead;
import cn.uglyservant.service.edu.excel.listener.SubjectListener;
import cn.uglyservant.service.edu.mapper.SubjectMapper;
import cn.uglyservant.service.edu.service.SubjectService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author uglyservant
 * @since 2020-07-18
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    SubjectListener subjectListener;

    @Override
    public void uploadSubjects(MultipartFile subjects) {
        try {
            EasyExcel.read(
                    subjects.getInputStream(),
                    SubjectHead.class,
                    subjectListener
            ).sheet().doRead();
        } catch (IOException e) {
            throw new GuliException("上传课程信息异常", e);
        }
    }
}
