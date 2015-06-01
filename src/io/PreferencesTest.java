package io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * 测试偏好设置类
 * @author skywalker
 *
 */
public class PreferencesTest {

	public static void main(String[] args) throws BackingStoreException {
		Preferences pre = Preferences.userRoot();
		//显示出基类中所有的值
		for(String key : pre.keys()) {
			System.out.println("key:" + key + "value:" + pre.get(key, ""));
		}
		
		pre.remove("JetBrains.WebStorm.e0201bbf.evlsprt3.9.0");
		
		pre.put("skywalker", "测试");
		
		for(String key : pre.keys()) {
			System.out.println("key:" + key + "value:" + pre.get(key, ""));
		}
		
		pre.remove("skywalker");
	}
	
}
