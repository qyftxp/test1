package com.yc.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;



public class FileUpload {
	private long singleSize = 50 * 1024 * 1024;
	public Map<String, String> uploadFiles(PageContext pageContext, HttpServletRequest request)
			throws SmartUploadException, IOException, ServletException, SQLException {
		Map<String, String> map = new HashMap<String, String>();

		SmartUpload su = new SmartUpload();
		su.initialize(pageContext); // ��ʼ��
		su.setCharset("utf-8");
		// ���������ϴ��ļ�����
		su.setAllowedFilesList("gif,jpg,jpeg,png");
		// �������ϴ��ļ�����
		su.setDeniedFilesList("jsp,asp,php,aspx,html,htm,exe,bat,sh");
		// �����ļ��������
		su.setMaxFileSize(singleSize);
		// �����ϴ��ļ�������������
		su.setTotalMaxFileSize(5 * singleSize);
		su.upload();
		
		// ȡ���� Request��smartupload��request -> HttpServletRequest
		Request re = su.getRequest();
		Enumeration<String> enu = re.getParameterNames();
		while (enu.hasMoreElements()) {
			String pn = enu.nextElement();
			map.put(pn, re.getParameter(pn));
		}
		// ȡ���ϴ����ļ��б�
		Files files = su.getFiles();
		if(files!=null&&files.getCount()>0){
			for(int i=0;i<files.getCount();i++){
			// ֻȡ�б��еĵ�һ���ļ� , дȫ·������ֹϵͳ��Ϊ�� java.io.File��
			com.jspsmart.upload.File file = files.getFile(i);
			// ȡtomcat·��
			Calendar c = Calendar.getInstance();
			String tomcatdir = request.getSession().getServletContext().getRealPath("/");// E:\tomcat\webapps/JavaEE_onlineorder
			File tomcatFile = new File(tomcatdir);
			File webapppath = tomcatFile.getParentFile(); // E:\tomcat\webapps

			// E:\tomcat\webapps/pic/2017/7
			File picpath = new File(webapppath, "pic" + File.separator + c.get(Calendar.YEAR) + File.separator
				+ (c.get(Calendar.MONTH) + 1) + File.separator);
			// ����·����
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			String weburl = basePath+"/pic/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/";
			// �ж�Ŀ¼�Ƿ���ڣ������򴴽�
			if (picpath.exists() == false) {
				picpath.mkdirs();
			}
			String filePrefixName = genNewFilePrefixName();
			// ȡ��ԭ�ļ��ĺ�׺��
			String extName = file.getFileExt();
			// ƴ���µ��ļ���
			String fileName = filePrefixName + "." + extName;

			weburl += fileName;
			// ����·��: xxx/xxx/webapps/pic/2017/7/20170720222222.png
			String destFilePathName = picpath + "/" + fileName;
			// ��
			file.saveAs(destFilePathName, SmartUpload.SAVE_PHYSICAL);
			
			
			//ȡ���ϴ��ļ�������
			String fieldName=file.getFieldName();
			
			String oldFileName=file.getFileName();
			
			map.put(fieldName+"_weburl", weburl);
			map.put(fieldName+"_destFilePathName_", destFilePathName);
			map.put(fieldName+"_fileName",oldFileName);
			}
		}
		return map;
		
	}

	
	private String genNewFilePrefixName() {
		// �����µ��ļ���
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("SSyyyyMMddHHmmss");
		String filePrefixName = sdf.format(d); // �ļ���ǰ׺��
		return filePrefixName;
	}


	public long getSingleSize() {
		return singleSize;
	}


	public void setSingleSize(long singleSize) {
		this.singleSize = singleSize;
	}
	
	
}