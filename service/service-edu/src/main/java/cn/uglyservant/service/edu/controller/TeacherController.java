package cn.uglyservant.service.edu.controller;



import cn.uglyservant.common.global.R;
import cn.uglyservant.common.global.exception.GuliException;
import cn.uglyservant.common.service.dto.TeacherQuery;
import cn.uglyservant.common.service.vo.Paged;
import cn.uglyservant.common.global.V;
import cn.uglyservant.service.edu.entity.Teacher;
import cn.uglyservant.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author uglyservant
 * @since 2020-06-06
 */
@Api(tags = "讲师管理")
@CrossOrigin
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation("查询所有讲师(带条件分页)")
    @PostMapping("/conditional-page-list/{page}/{size}")
    public R conditionalPageList(@PathVariable Long page, @PathVariable Long size,
                                 @RequestBody TeacherQuery teacherQuery) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(teacherQuery.getName())) {
            queryWrapper.like("name", teacherQuery.getName());
        }
        if (teacherQuery.getLevel() != null) {
            queryWrapper.eq("level", teacherQuery.getLevel());
        }
        if (StringUtils.isNotBlank(teacherQuery.getBegin())) {
            queryWrapper.ge("gmt_create", teacherQuery.getBegin());
        }
        if (StringUtils.isNotBlank(teacherQuery.getEnd())) {
            queryWrapper.le("gmt_create", teacherQuery.getEnd());
        }
        queryWrapper.orderByDesc("gmt_create");
        // queryWrapper.orderByAsc("sort").orderByAsc("level");
        Page<Teacher> teacherPage = teacherService.page(new Page<>(page, size), queryWrapper);

        return R.ok(new Paged(teacherPage.getTotal(), teacherPage.getRecords()));
    }

    @ApiOperation("查询一个讲师")
    @GetMapping("/find-by-id/{id}")
    public R findById(@PathVariable String id) {
        return R.ok(new V("teacher", teacherService.getById(id)));
    }

    @ApiOperation("删除一个讲师")
    @DeleteMapping("/delete-by-id/{id}")
    public R deleteById(@PathVariable String id) {
        if (!teacherService.removeById(id)) {
            throw new GuliException("删除讲师失败，讲师ID：" + id);
        }

        return R.ok(null);
    }

    @ApiOperation("添加一个讲师")
    @PostMapping("/add-new")
    public R addNew(@RequestBody Teacher teacher) {
        if (!teacherService.save(teacher)) {
            throw new GuliException("添加讲师失败，讲师ID：" + teacher.getId());
        }

        return R.ok(null);
    }

    @ApiOperation("更新一个讲师")
    @PutMapping("/update-by-id")
    public R updateById(@RequestBody Teacher teacher) {
        if (!teacherService.updateById(teacher)) {
            throw new GuliException("更新讲师失败，讲师ID" + teacher.getId());
        }

        return R.ok(null);
    }
}
