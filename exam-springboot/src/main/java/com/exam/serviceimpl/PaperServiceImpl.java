package com.exam.serviceimpl;

import com.exam.entity.PaperManage;
import com.exam.mapper.PaperMapper;
import com.exam.service.PaperService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class PaperServiceImpl implements PaperService {

    private final PaperMapper paperMapper;

    public PaperServiceImpl(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }

    @Override
    public List<PaperManage> findAll() {
        return paperMapper.findAll();
    }

    @Override
    public List<PaperManage> findById(Integer paperId) {
        return paperMapper.findById(paperId);
    }

    @Override
    public int add(PaperManage paperManage) {
        return paperMapper.add(paperManage);
    }

}
