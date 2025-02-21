/*
 *  This file (TabListCon.java) is a part of project XConomy
 *  Copyright (C) YiC and contributors
 *
 *  This program is free software: you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 *  for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package me.yic.xconomy.utils;

import me.yic.xconomy.XConomyLoad;
import me.yic.xconomy.info.HiddenINFO;

import java.util.HashSet;
import java.util.Set;

public class TabListCon {

    private static Set<String> tabPlayerList = new HashSet<>();

    public static void addPlayerName(String name){
        if (!tabPlayerList.contains(name)) {
            if (name != null && !HiddenINFO.getHidden(name)) {
                if (XConomyLoad.getSyncData_Enable()) {
                    Set<String> copiedList = new HashSet<>(tabPlayerList);
                    copiedList.add(name);
                    renew_Tab_PlayerList(copiedList);
                }else{
                    tabPlayerList.add(name);
                }
            }
        }
    }

    public static void removePlayerName(String name){
        if (tabPlayerList.contains(name)) {
            if (XConomyLoad.getSyncData_Enable()) {
                Set<String> copiedList = new HashSet<>(tabPlayerList);
                copiedList.removeIf(ee -> ee == null || ee.equals(name));
                renew_Tab_PlayerList(copiedList);
            }else{
                tabPlayerList.removeIf(ee -> ee == null || ee.equals(name));
            }
        }
    }

    public static void renew_Tab_PlayerList(Set<String> rn){
        if (rn != null) {
            tabPlayerList = rn;
        }
    }

    public static Set<String> get_Tab_PlayerList(){
        return tabPlayerList;
    }
}
