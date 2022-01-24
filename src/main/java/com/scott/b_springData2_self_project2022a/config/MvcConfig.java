package com.scott.b_springData2_self_project2022a.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Value("${upload.path}")
	private String uploadDir;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory("swimmerphotos", registry);
	}
	
	private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		Path path = Paths.get(uploadDir, dirName);
		String uploadPath = path.toFile().getAbsolutePath();
		
		//if(dirName.startsWith("../")) dirName = dirName.replace("../", "");
		dirName=dirName.replaceAll("\\.\\./", "");
		registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("file:/"+uploadPath+"/");
	}
}
