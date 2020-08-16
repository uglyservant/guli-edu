package cn.uglyservant.service.edu.service;

import cn.uglyservant.service.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author uglyservant
 * @since 2020-07-18
 */
public interface SubjectService extends IService<Subject> {

    void uploadSubjects(MultipartFile subjects);
}
