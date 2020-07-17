package cn.uglyservant.service.edu.service.impl;

import cn.uglyservant.service.edu.entity.Subject;
import cn.uglyservant.service.edu.mapper.SubjectMapper;
import cn.uglyservant.service.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public void uploadSubjects(MultipartFile subjects) {

    }
}
