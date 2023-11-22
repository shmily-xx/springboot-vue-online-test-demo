package com.exam.serviceimpl;

import com.exam.entity.PaperManage;
import com.exam.mapper.PaperMapper;
import com.exam.service.PaperService;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return paperMapper.selectList(null);
    }

    @Override
    public List<PaperManage> findById(Integer paperId) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("paperId", paperId);
        return paperMapper.selectByMap(columnMap);
    }

    @Override
    public int add(PaperManage paperManage) {
        return paperMapper.insert(paperManage);
    }

}
