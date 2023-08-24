package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.MultiQuestion;
import com.exam.mapper.MultiQuestionMapper;
import com.exam.service.MultiQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {

    private final MultiQuestionMapper multiQuestionMapper;

    public MultiQuestionServiceImpl(MultiQuestionMapper multiQuestionMapper) {
        this.multiQuestionMapper = multiQuestionMapper;
    }

    @Override
    public List<MultiQuestion> findByIdAndType(Integer paperId) {
        return multiQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<MultiQuestion> findAll(Page<MultiQuestion> page) {
        return multiQuestionMapper.findAll(page);
    }

    @Override
    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(MultiQuestion multiQuestion) {
        return multiQuestionMapper.add(multiQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return multiQuestionMapper.findBySubject(subject,pageNo);
    }
}
