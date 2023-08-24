package com.exam.serviceimpl;

import com.exam.entity.Replay;
import com.exam.mapper.ReplayMapper;
import com.exam.service.ReplayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class ReplayServiceImpl implements ReplayService {

    private final ReplayMapper replayMapper;

    public ReplayServiceImpl(ReplayMapper replayMapper) {
        this.replayMapper = replayMapper;
    }

    @Override
    public List<Replay> findAll() {
        return replayMapper.findAll();
    }

    @Override
    public List<Replay> findAllById(Integer messageId) {
        return replayMapper.findAllById(messageId);
    }

    @Override
    public Replay findById(Integer replayId) {
        return replayMapper.findById(replayId);
    }

    @Override
    public int delete(Integer replayId) {
        return replayMapper.delete(replayId);
    }

    @Override
    public int update(Replay replay) {
        return replayMapper.update(replay);
    }

    @Override
    public int add(Replay replay) {
        return replayMapper.add(replay);
    }
}
