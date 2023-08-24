package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.JudgeQuestion;
import com.exam.mapper.JudgeQuestionMapper;
import com.exam.service.JudgeQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {

    private final JudgeQuestionMapper judgeQuestionMapper;

    public JudgeQuestionServiceImpl(JudgeQuestionMapper judgeQuestionMapper) {
        this.judgeQuestionMapper = judgeQuestionMapper;
    }

    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<JudgeQuestion> findAll(Page<JudgeQuestion> page) {
        return judgeQuestionMapper.findAll(page);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.add(judgeQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return judgeQuestionMapper.findBySubject(subject,pageNo);
    }
}
