package io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * ����ƫ��������
 * @author skywalker
 *
 */
public class PreferencesTest {

	public static void main(String[] args) throws BackingStoreException {
		Preferences pre = Preferences.userRoot();
		//��ʾ�����������е�ֵ
		for(String key : pre.keys()) {
			System.out.println("key:" + key + "value:" + pre.get(key, ""));
		}
		
		pre.remove("JetBrains.WebStorm.e0201bbf.evlsprt3.9.0");
		
		pre.put("skywalker", "����");
		
		for(String key : pre.keys()) {
			System.out.println("key:" + key + "value:" + pre.get(key, ""));
		}
		
		pre.remove("skywalker");
	}
	
}
