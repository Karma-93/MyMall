package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.SmsFlashPromotionSession;
import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 */
@Getter
@Setter
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {
    private Long productCount;
}
