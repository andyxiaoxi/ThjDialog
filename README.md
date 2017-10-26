# ThjDialog
简单dialog

gradle 依赖：

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
 
 
	dependencies {
	        compile 'com.github.andyxiaoxi:ThjDialog:v1.0.0'
	}
  
  
  
maven 依赖：

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
	</repositories>
  
 <dependency>
	    <groupId>com.github.andyxiaoxi</groupId>
	    <artifactId>ThjDialog</artifactId>
	    <version>v1.0.0</version>
	</dependency>
  
  
  How to use：
  
        CustomDialog dialog = new CustomDialog(this);
        
        dialog.show("提示","这是一条消息");
