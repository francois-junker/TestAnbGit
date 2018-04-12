/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.dao;

import be.anbrimex.bibus.dao.Entity.IPConfigHAEth0;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */
public class IpConfigDao extends BibusDao {

    private static final Logger LOGGER = Logger.getLogger(IpConfigDao.class.getName());

    private static final String TABLE_NAME = "BibusProjectDB.IPConfigHAEth0_TEST";

    public static IPConfigHAEth0 getIpConfig() {
        try {
            String str = "SELECT * FROM " + TABLE_NAME + ";";
            ResultSet rs = getConnection().createStatement().executeQuery(str);
            rs.last();
            IPConfigHAEth0 allIPConfigHAEth0 = new IPConfigHAEth0();
            allIPConfigHAEth0.setIP_Port_HomeAnyWhere(rs.getInt("IP_Port_HomeAnyWhere"));
            allIPConfigHAEth0.setIP_Password(rs.getString("IP_Password"));
            allIPConfigHAEth0.setIP_UserName(rs.getString("IP_UserName"));
            allIPConfigHAEth0.setRelayIP_HomeAnyWhere(rs.getString("RelayIP_HomeAnyWhere"));
            allIPConfigHAEth0.setRelayPORT_HomeAnyWhere(rs.getInt("RelayPORT_HomeAnyWhere"));
            allIPConfigHAEth0.setRelayIP_UserName(rs.getString("RelayIP_UserName"));
            allIPConfigHAEth0.setRelayIP_Password(rs.getString("RelayIP_Password"));
            allIPConfigHAEth0.setUDPServerPort(rs.getInt("UDPServerPort"));
            allIPConfigHAEth0.setUDP_UserName(rs.getString("UDP_UserName"));
            allIPConfigHAEth0.setUDP_Password(rs.getString("UDP_Password"));
            return allIPConfigHAEth0;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error while the select... TableName = " + TABLE_NAME, ex);
            return null;
        }
    }

    public static void updateIpConfig(final IPConfigHAEth0 ipConfig) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append(TABLE_NAME).append(" SET ")
                    .append("IP_Port_HomeAnyWhere = '").append(ipConfig.getIP_Port_HomeAnyWhere()).append("',")
                    .append("IP_UserName = '").append(ipConfig.getIP_UserName()).append("',")
                    .append("IP_Password = '").append(ipConfig.getIP_Password()).append("',")
                    .append("RelayIP_HomeAnyWhere = '").append(ipConfig.getRelayIP_HomeAnyWhere()).append("',")
                    .append("RelayPORT_HomeAnyWhere = '").append(ipConfig.getRelayPORT_HomeAnyWhere()).append("',")
                    .append("RelayIP_UserName = '").append(ipConfig.getRelayIP_UserName()).append("',")
                    .append("RelayIP_Password = '").append(ipConfig.getRelayIP_Password()).append("',")
                    .append("UDPServerPort = '").append(ipConfig.getUDPServerPort()).append("',")
                    .append("UDP_UserName = '").append(ipConfig.getUDP_UserName()).append("',")
                    .append("UDP_Password = '").append(ipConfig.getUDP_Password()).append("';");
            getConnection().createStatement().executeUpdate(sb.toString());
            LOGGER.log(Level.INFO, sb.toString());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error while the update... TableName = " + TABLE_NAME, ex);
        }
    }
}
