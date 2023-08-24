package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.mapper.AnswerMapper;
import com.exam.service.AnswerService;
import com.exam.vo.AnswerVO;
import org.springframework.stereotype.Service;

/**
 * @author weidie
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public IPage<AnswerVO> findAll(Page<AnswerVO> page) {
        return answerMapper.findAll(page);
    }
}
