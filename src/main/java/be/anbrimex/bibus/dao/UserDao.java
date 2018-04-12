/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.dao;

import be.anbrimex.bibus.dao.Entity.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francois
 */
public class UserDao extends BibusDao {

    public static List<User> findAllUsers() {
        List<User> users = new ArrayList<User>();

        String table_user = "BibusProjectDB.user";
        try {
            Statement stmt = getConnection().createStatement();
            String str = "SELECT `user`.`User`,\n"
                    + "    `user`.`Active`,\n"
                    + "    `user`.`Nom`,\n"
                    + "    `user`.`Part1`,\n"
                    + "    `user`.`Part2`,\n"
                    + "    `user`.`Part3`,\n"
                    + "    `user`.`Part4`,\n"
                    + "    `user`.`Part5`,\n"
                    + "    `user`.`Part6`,\n"
                    + "    `user`.`Part7`,\n"
                    + "    `user`.`Part8`,\n"
                    + "    `user`.`Attribut`,\n"
                    + "    `user`.`MAttribut`,\n"
                    + "    `user`.`Password`,\n"
                    + "    `user`.`Up_Dl_Nr`,\n"
                    + "    `user`.`KeyboardAccess`,\n"
                    + "    `user`.`Twr`,\n"
                    + "    `user`.`Trd` FROM " + table_user;
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {
                User user = new User();
                user.setNom(rs.getString("Nom"));
                user.setPassword(rs.getString("Password"));
                user.setUp_Dl_Nr(rs.getInt("Up_Dl_Nr"));
                user.setUser(rs.getInt("User"));
                user.setActive(rs.getInt("Active"));
                user.setAttribut(rs.getInt("Attribut"));
                user.setMAttribut(rs.getInt("MAttribut"));
                user.setTrd(rs.getInt("Trd"));
                user.setTwr(rs.getInt("Twr"));
                user.setPart1(rs.getInt("Part1"));
                user.setPart2(rs.getInt("Part2"));
                user.setPart3(rs.getInt("Part3"));
                user.setPart4(rs.getInt("Part4"));
                user.setPart5(rs.getInt("Part5"));
                user.setPart6(rs.getInt("Part6"));
                user.setPart7(rs.getInt("Part7"));
                user.setPart8(rs.getInt("Part8"));
                user.setKeyboardAccess(rs.getInt("KeyboardAccess"));

                users.add(user);
            }

        } catch (Exception ex) {
            System.err.println("error :" + ex.getMessage());
        }
        return users;
    }

}
