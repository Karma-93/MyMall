package com.alone.mymall.service;

import com.alone.mymall.mgb.model.UmsMemberLevel;

import java.util.List;

public interface UmsMemberLevelService {
    List<UmsMemberLevel> list(Integer defaultStatus);
}
