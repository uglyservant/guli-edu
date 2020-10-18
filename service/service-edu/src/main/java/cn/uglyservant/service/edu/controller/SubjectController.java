package cn.uglyservant.service.edu.controller;


import cn.uglyservant.common.global.R;
import cn.uglyservant.common.global.exception.GuliException;
import cn.uglyservant.service.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author uglyservant
 * @since 2020-07-18
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/uploadSubjects")
    public R uploadSubjects(MultipartFile subjects) {
        subjectService.uploadSubjects(subjects);
        return R.ok(null);
    }
}

