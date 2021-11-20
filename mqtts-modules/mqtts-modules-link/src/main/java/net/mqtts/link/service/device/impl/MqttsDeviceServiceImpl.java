package net.mqtts.link.service.device.impl;

import net.mqtts.common.core.utils.DateUtils;
import net.mqtts.common.security.service.TokenService;
import net.mqtts.link.api.domain.MqttsDevice;
import net.mqtts.link.mapper.device.MqttsDeviceMapper;
import net.mqtts.link.service.device.MqttsDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备管理Service业务层处理
 * 
 * @author mqtts
 * @date 2021-10-22
 */
@Service
public class MqttsDeviceServiceImpl implements MqttsDeviceService
{
    @Autowired
    private MqttsDeviceMapper mqttsDeviceMapper;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public MqttsDevice selectMqttsDeviceById(Long id)
    {
        return mqttsDeviceMapper.selectMqttsDeviceById(id);
    }

    /**
     * 查询设备管理列表
     * 
     * @param mqttsDevice 设备管理
     * @return 设备管理
     */
    @Override
    public List<MqttsDevice> selectMqttsDeviceList(MqttsDevice mqttsDevice)
    {
        return mqttsDeviceMapper.selectMqttsDeviceList(mqttsDevice);
    }

    /**
     * 新增设备管理
     * 
     * @param mqttsDevice 设备管理
     * @return 结果
     */
    @Override
    public int insertMqttsDevice(MqttsDevice mqttsDevice)
    {
        mqttsDevice.setCreateBy(tokenService.getLoginUser().getUsername());
        mqttsDevice.setCreateTime(DateUtils.getNowDate());
        return mqttsDeviceMapper.insertMqttsDevice(mqttsDevice);
    }

    /**
     * 修改设备管理
     * 
     * @param mqttsDevice 设备管理
     * @return 结果
     */
    @Override
    public int updateMqttsDevice(MqttsDevice mqttsDevice)
    {
        mqttsDevice.setUpdateBy(tokenService.getLoginUser().getUsername());
        mqttsDevice.setUpdateTime(DateUtils.getNowDate());
        return mqttsDeviceMapper.updateMqttsDevice(mqttsDevice);
    }

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteMqttsDeviceByIds(Long[] ids)
    {
        return mqttsDeviceMapper.deleteMqttsDeviceByIds(ids);
    }

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteMqttsDeviceById(Long id)
    {
        return mqttsDeviceMapper.deleteMqttsDeviceById(id);
    }

    @Override
    public MqttsDevice findOneByClientIdAndUserNameAndPassword(String clientId, String userName, String password) {
        return mqttsDeviceMapper.findOneByClientIdAndUserNameAndPassword(clientId,userName,password);
    }

	@Override
	public MqttsDevice findOneByClientIdAndUserNameAndPasswordAndDeviceStatusAndProtocolType(String clientId,String userName,String password,String deviceStatus,String protocolType){
		 return mqttsDeviceMapper.findOneByClientIdAndUserNameAndPasswordAndDeviceStatusAndProtocolType(clientId,userName,password,deviceStatus,protocolType);
	}


	@Override
	public int updateConnectStatusByClientId(String updatedConnectStatus,String clientId){
		 return mqttsDeviceMapper.updateConnectStatusByClientId(updatedConnectStatus,clientId);
	}









}