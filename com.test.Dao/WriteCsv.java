package com.test.Dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** 
* CSV操作
* @author zhang(PSTTEC)
* @version 2019-05-21
*/
public class WriteCsv {

	/***
	 * 
	 * @param file ファイル名
	 * @param dataList　データ配列
	 * @return
	 */
	public boolean exportCsv(String fileName, List<?> dataList) {
		//結果
		boolean isSucess = false;
		FileWriter fw = null;
		BufferedWriter bw = null;
		//
		try {
			//新規ファイル
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);

			if (dataList != null && !dataList.isEmpty()) {
				for (Object data : dataList) {
					bw.append(data.toString()).append(",");
				}
				bw.append("\r");
			}
			isSucess = true;
		} catch (Exception e) {
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
					fw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isSucess;
	}

	/***
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List dataList = new ArrayList();
		dataList.add("12,zzz,男");
		dataList.add(2);
		dataList.add(3.33);

		WriteCsv wtc = new WriteCsv();
		boolean isSuccess = wtc.exportCsv("test.csv", dataList);
		System.out.println(isSuccess);
	}

}
