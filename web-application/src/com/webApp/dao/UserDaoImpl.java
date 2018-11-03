package com.webApp.dao;

import com.webApp.model.Action;
import com.webApp.model.Role;
import com.webApp.model.User;
import com.webApp.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao  {

    private final String INSERT_NEW_USER_DATA="insert into user( username, email, token, password, id_role ) values (?, ?, ?, ?, ?)";
    private final String GET_ALL_ACTION_TYPE_BY_ROLE_ID = "select a.action_type from role_action ra inner join action a on ra.id_action = a.id_action where id_role = ?";
    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public boolean registerNewUser(User user) {
        Connection con =  null;
        PreparedStatement ps = null;
        boolean result = false;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(INSERT_NEW_USER_DATA);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getToken());
            ps.setString(4, user.getPassword());
            ps.setInt(5, 3);
            result = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con, ps);
        }
        return result;
    }

    @Override
    public boolean activateUserByToken(String token, String newToken) {
        return false;
    }

    @Override
    public User loginUser(String email, String password) {
        return null;
    }

    @Override
    public boolean isActionAllowed(int idRole, String action) {
        return false;
    }

    @Override
    public List<Action> getActionsByRoleId(int idRole) {
        Connection con =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Action> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_ACTION_TYPE_BY_ROLE_ID);
            ps.setInt(1, idRole);
            rs = ps.executeQuery();
            while (rs.next()){
                Action action = new Action();
                action.setActionType(rs.getString("action_type"));
                list.add(action);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return list;
    }


}
