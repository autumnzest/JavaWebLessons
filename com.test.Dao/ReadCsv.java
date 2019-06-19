package com.test.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.test.Bean.UserBean;

/** 
* 
* @author zhang(PSTTEC)
* @version 2019-05-21
*/
public class ReadCsv {

	/***
	 * 
	 * @param file
	 * @return
	 */
	public static List<UserBean> importCsv(String fileName) {
		List<UserBean> dataList = new ArrayList<UserBean>();

		//新規ファイル
		File file = new File(fileName);
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				
				UserBean sbn = new UserBean();
				String[] s = line.split(",");
				sbn.setName(s[0]);
				sbn.setPassword(s[1]);
				sbn.setSex(s[2]);
				sbn.setAge(Integer.valueOf(s[3]));
				sbn.setCountry(s[4]);
				sbn.setMemo(s[5]);
				dataList.add(sbn);
				
			}
		} catch (Exception e) {
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataList;
	}

	/***
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File directory = new File("xxx.csv");//フィルだ C:\\Program Files\\workspace\\Test2\\WebContent\\csv\\xxx.csv
		try{ 
		    System.out.println(directory.getCanonicalPath());//path1
		    System.out.println(directory.getAbsolutePath());//path2
		}catch(Exception e){} 
		importCsv();
	}

	/***
	 * 
	 */
	public static void importCsv() {
		List dataList = importCsv("test.csv");//フィルだ C:\\Program Files\\workspace\\Test2\\WebContent\\csv\\xxx.csv
		if (dataList != null && !dataList.isEmpty()) {
			for (int i = 0; i < dataList.size(); i++) {
				if (i != 0) {
					String s = dataList.get(i).toString();
					//System.out.println("s " + s);
					//String[] as = s.split(",");
					System.out.println(s);
					//System.out.println(as[1]);
					//System.out.println(as[2]);
				}
			}
		}
	}
}
