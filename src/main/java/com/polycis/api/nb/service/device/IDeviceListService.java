package com.polycis.api.nb.service.device;

import com.polycis.api.nb.entity.device.DeviceEntity;

import java.util.List;

public interface IDeviceListService {

    List<DeviceEntity> getDeviceList(DeviceEntity deviceEntity);
}
