package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Score;
import com.exam.mapper.ScoreMapper;
import com.exam.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    public ScoreServiceImpl(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    @Override
    public int add(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreMapper.selectList(null);
    }

    @Override
    public IPage<Score> findById(Page<Score> page, Integer studentId) {
        Wrapper<Score> queryWrapper = new QueryWrapper<Score>().eq("studentId", studentId);
        return scoreMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Score> findById(Integer studentId) {
        Wrapper<Score> queryWrapper = new QueryWrapper<Score>().eq("studentId", studentId);
        return scoreMapper.selectList(queryWrapper);
    }

    @Override
    public List<Score> findByExamCode(Integer examCode) {
        return scoreMapper.findByExamCode(examCode);
    }
}
