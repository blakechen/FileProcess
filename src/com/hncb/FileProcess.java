package com.hncb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileProcess {

	public static void main(String[] args) {
		FileProcess fp=new FileProcess();
		
		try {
			 List<String> fromList=fp.getFileToList("/usr/hncb/from.txt");
			 fp.getMemeryUsed();
			 List<String> referenceList=fp.getFileToList("/usr/hncb/reference.txt");
			 fp.getMemeryUsed();
			 List<String> resultList=new ArrayList();
			 fromList.forEach(line->{
				String[]content= line.split(",");
				Set ipcontent=new HashSet();
				referenceList.forEach(line2->{
					String[]content2= line2.split(",");
						if(content[0].equals(content2[2])) {
							
						}
				});
			 });
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String getMemeryUsed() {
		String result="MemoryUsed:"+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/(1024*1024)+"MB";
		System.out.println(result);
		return result;
	}
	
	/**
	 * save file list to Memory as List
	 * @param fullFilePath
	 * @return
	 * @throws FileNotFoundException
	 */
	private List<String> getFileToList(String fullFilePath) throws FileNotFoundException {
		InputStream is = new FileInputStream(new File(fullFilePath));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		Long start=System.currentTimeMillis();
		List<String> result = br.lines()
		    .collect(Collectors.toList());
		System.out.println("Totle time:"+(System.currentTimeMillis()-start)+"ms");
		return result;
	}
//	public static Function<String,String> mapToString = (line) -> {
//		  String[] p = line.split(", ");
//		  return new Person(p[0], line);
//		};
}
