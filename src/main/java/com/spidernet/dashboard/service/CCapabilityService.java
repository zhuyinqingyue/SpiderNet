package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.CCapability;

public interface CCapabilityService
{
    List<CCapability> viewCCapability(String blockId, String buList);
    CCapability fetchCommonCapabilty(String capabilityId);
}
