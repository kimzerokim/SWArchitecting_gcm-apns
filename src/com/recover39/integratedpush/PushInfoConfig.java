package com.recover39.integratedpush;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import xmlLoader.ServiceListData;
import xmlLoader.SettingData;
import xmlLoader.SettingListData;

public class PushInfoConfig {
	private static Logger logger = Logger.getLogger(PushInfoConfig.class);
	public static String APNS_certificationFileLocation;
	public static String APNS_certificationFilePassword;
	public static String GCM_APIKEY;

	public PushInfoConfig() {
		setPushServiceConfig();
	};

	private static void setPushServiceConfig() {
		Serializer serializer = new Persister();
		File file = new File("pushConfig.xml");

		try {
			ServiceListData serviceList = serializer.read(
					ServiceListData.class, file);

			for (SettingListData settingListData : serviceList.getService()) {
				if (settingListData.getName().equals("ios")) {
					List<SettingData> settingList = settingListData
							.getSetting();
					for (SettingData settingData : settingList) {
						if (settingData.getProperty().equals("certificate")) {
							APNS_certificationFileLocation = settingData
									.getContent();
						} else if (settingData.getProperty().equals("password")) {
							APNS_certificationFilePassword = settingData
									.getContent();
						}
					}
				} else if (settingListData.getName().equals("android")) {
					List<SettingData> settingList = settingListData
							.getSetting();
					for (SettingData settingData : settingList) {
						if (settingData.getProperty().equals("apiKey")) {
							GCM_APIKEY = settingData.getContent();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
