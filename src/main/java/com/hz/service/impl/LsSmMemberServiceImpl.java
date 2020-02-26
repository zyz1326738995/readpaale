package com.hz.service.impl;

import com.hz.mapper.LsSmMemberMapper;
import com.hz.pojo.SmLevel;
import com.hz.pojo.SmMember;
import com.hz.service.LsSmMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员信息
 */
@Service("lsSmMemberService")
public class LsSmMemberServiceImpl implements LsSmMemberService {
    @Resource
    private LsSmMemberMapper lsSmMemberMapper;

    @Override
    public List<SmMember> getsmMemberAllInfo(Integer curr, Integer limit, String datemin, String datemax, String love) {
        return lsSmMemberMapper.getsmMemberAllInfo((curr-1)*limit,  limit,  datemin,  datemax,  love);
    }

    @Override
    public List<SmMember> getsAllmMemberAllInfoyears(Integer curr, Integer limit, String datemin, String datemax, String love) {
        return lsSmMemberMapper.getsAllmMemberAllInfoyears((curr-1)*limit,  limit,  datemin,  datemax,  love);
    }

    @Override
    public int getMemberCount(String datemin, String datemax, String love) {
        return lsSmMemberMapper.getMemberCount(datemin,  datemax,  love);
    }

    @Override
    public int getMemberCountyears(String datemin, String datemax, String love) {
        return lsSmMemberMapper.getMemberCountyears(datemin,  datemax,  love);
    }

    @Override
    public List<SmMember> exportExcelMember() {
        return lsSmMemberMapper.exportExcelMember();
    }

    @Override
    public int UpdateStates(long member_id, long member_state) {
        return lsSmMemberMapper.UpdateStates(member_id,member_state);
    }

    @Override
    public int addSmMember(SmMember smMember) {
        return lsSmMemberMapper.addSmMember(smMember);
    }

    @Override
    public SmMember getMemberByNameAndNumb(SmMember smMember) {
        return lsSmMemberMapper.getMemberByNameAndNumb(smMember);
    }

    @Override
    public List<SmLevel> getAllSmLevel() {
        return lsSmMemberMapper.getAllSmLevel();
    }

    @Override
    public int editSmLevelId(SmMember smMember) {
        return lsSmMemberMapper.editSmLevelId(smMember);
    }

}
