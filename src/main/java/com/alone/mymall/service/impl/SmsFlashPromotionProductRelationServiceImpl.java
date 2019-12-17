package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.SmsFlashPromotionProductRelationMapper;
import com.alone.mymall.mgb.model.SmsFlashPromotionProductRelation;
import com.alone.mymall.mgb.model.SmsFlashPromotionProductRelationExample;
import com.alone.mymall.pojo.SmsFlashPromotionProduct;
import com.alone.mymall.service.SmsFlashPromotionProductRelationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService {

    @Autowired
    private SmsFlashPromotionProductRelationMapper flashPromotionProductRelationMapper;

    @Override
    public int create(List<SmsFlashPromotionProductRelation> relationList) {
        for (SmsFlashPromotionProductRelation relation:relationList){
            flashPromotionProductRelationMapper.insert(relation);
        }
        return relationList.size();
    }

    @Override
    public int update(Long id, SmsFlashPromotionProductRelation relation) {
        relation.setId(id);
        return flashPromotionProductRelationMapper.updateByPrimaryKey(relation);
    }

    @Override
    public int delete(Long id) {
        return flashPromotionProductRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SmsFlashPromotionProductRelation getItem(Long id) {
        return flashPromotionProductRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return flashPromotionProductRelationMapper.getList(flashPromotionId,flashPromotionSessionId);
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        SmsFlashPromotionProductRelationExample example = new SmsFlashPromotionProductRelationExample();
        example.createCriteria()
                .andFlashPromotionIdEqualTo(flashPromotionId)
                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        return flashPromotionProductRelationMapper.countByExample(example);
    }
}
